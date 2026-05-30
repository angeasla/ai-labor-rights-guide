package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ChatRequestDto;
import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AiChatService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public AiChatService(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClientBuilder.build();
    }

    public String generateResponse(ChatRequestDto request) {
        List<ChatMessageDto> messages = request.getMessages();

        if (messages == null || messages.isEmpty()) {
            return "Παρακαλώ γράψτε μια ερώτηση.";
        }

        // 1. Βρίσκουμε το ΤΕΛΕΥΤΑΙΟ μήνυμα του χρήστη για να ψάξουμε στο ChromaDB
        String latestUserMessage = messages.getLast().getContent();

        // 2. Αναζήτηση στο ChromaDB
        List<Document> similarDocuments = vectorStore.similaritySearch(latestUserMessage);

        String context = similarDocuments.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));

        // 3. Το δυναμικό System Prompt
        String dynamicSystemPrompt = """
            Είσαι ένας έμπειρος, ενσυναισθητικός και προσεκτικός σύμβουλος εργασιακών δικαιωμάτων στην Ελλάδα.
            Ο ρόλος σου είναι να αναλύεις τα δεδομένα που σου δίνει ο εργαζόμενος και να παρέχεις εξατομικευμένες συμβουλές.
           \s
            ΒΑΣΙΚΟΣ ΚΑΝΟΝΑΣ ΕΛΛΗΝΙΚΟΥ ΩΡΑΡΙΟΥ (ΠΕΝΘΗΜΕΡΟ - 40 ΩΡΕΣ):
            - Η 9η ώρα την ημέρα (41η έως 45η ώρα την εβδομάδα) είναι ΑΥΣΤΗΡΑ 'Υπερεργασία' και αμείβεται με προσαύξηση 20%.
            - Από την 10η ώρα την ημέρα (46η ώρα την εβδομάδα και μετά) ξεκινά η 'Υπερωρία' (40% αν είναι νόμιμη, 120% αν είναι παράνομη/αδήλωτη).
            - Δεν υπάρχει 'δωρεάν' 9η ώρα. Το λογιστήριο που ισχυρίζεται κάτι τέτοιο παρανομεί.
           \s
            ΑΥΣΤΗΡΟΙ ΚΑΝΟΝΕΣ ΣΥΜΠΕΡΙΦΟΡΑΣ & ΕΡΓΑΛΕΙΑ ΥΠΟΛΟΓΙΣΜΟΥ (SOFT TRIGGERS):
            1. ΑΠΑΓΟΡΕΥΕΤΑΙ ΑΥΣΤΗΡΑ να χρησιμοποιείς εκφράσεις όπως 'βάσει του context', 'τα δεδομένα που έχω', 'το πλαίσιο που μου παρείχες', 'το αρχείο δεν περιέχει' ή οτιδήποτε παρόμοιο.\s
            2. Μην απολογείσαι ποτέ στον χρήστη για το αν υπάρχουν ή λείπουν πληροφορίες από το σύστημα. Απάντα άμεσα και φυσικά σαν αληθινός άνθρωπος-εργατολόγος.
            3. Έχεις στη διάθεσή σου ψηφιακά εργαλεία υπολογισμού (Tools). ΜΗΝ κάνεις πράξεις και πολύπλοκους μαθηματικούς υπολογισμούς μόνος σου (όπως ακριβή ποσά αποζημίωσης, δώρων, κλπ.).
            4. ΑΝ ο χρήστης ρωτάει ευθέως "πόσα δικαιούμαι" ή αν κρίνεις ότι ένας υπολογισμός ολοκληρώνει ιδανικά τη συμβουλή σου, ΠΡΕΠΕΙ να προσθέσεις στο ΤΕΛΟΣ του μηνύματός σου το αντίστοιχο tag του εργαλείου, ακριβώς όπως φαίνεται παρακάτω.
           \s
                ΛΙΣΤΑ ΕΡΓΑΛΕΙΩΝ (Χρησιμοποίησε ΜΟΝΟ ΕΝΑ tag στο τέλος της απάντησης, π.χ. [TOOL: severance]):
                - [TOOL: salary] (Υπολογισμός Καθαρού/Μικτού μισθού)
                - [TOOL: leave-days] (Υπολογισμός Ημερών Αδείας)
                - [TOOL: leave-part-time] (Ημέρες αδείας εκ περιτροπής)
                - [TOOL: leave-pay] (Αποδοχές και Επίδομα Αδείας)
                - [TOOL: severance] (Αποζημίωση Απόλυσης)
                - [TOOL: overtime] (Υπερωρίες / Νυχτερινά / 6η μέρα)
                - [TOOL: easter-bonus] (Δώρο Πάσχα)
                - [TOOL: easter-part-time] (Δώρο Πάσχα εκ περιτροπής)
                - [TOOL: easter-hourly] (Δώρο Πάσχα σε Ωρομίσθιους)
                - [TOOL: xmas-bonus] (Δώρο Χριστουγέννων)
                - [TOOL: xmas-part-time] (Δώρο Χριστουγέννων εκ περιτροπής)
                - [TOOL: xmas-hourly] (Δώρο Χριστουγέννων σε Ωρομίσθιους)
                - [TOOL: maternity] (Μητρότητα)
                - [TOOL: national-pension] (Εθνική Σύνταξη)
                - [TOOL: contributory-pension] (Ανταποδοτική Σύνταξη)
           \s
            ΠΛΗΡΟΦΟΡΙΕΣ ΕΡΓΑΣΙΑΚΟΥ ΟΔΗΓΟΥ:
            ---------------------
            {CONTEXT_PLACEHOLDER}
            ---------------------
            ΟΔΗΓΙΑ: Απάντησε στην ερώτηση συνδυάζοντας τις παραπάνω πληροφορίες. Αν είναι άσχετες, αγνόησέ τες σιωπηλά.
           \s""".replace("{CONTEXT_PLACEHOLDER}", context);

        // 4. Χτίσιμο του ιστορικού συζήτησης για το Spring AI
        List<Message> springMessages = new ArrayList<>();

        // Βάζουμε πρώτο το System Prompt
        springMessages.add(new SystemMessage(dynamicSystemPrompt));

        // Προσθέτουμε όλο το ιστορικό από την Angular
        for (ChatMessageDto msg : messages) {
            // Αν το dto έχει getRole() επιστρέφει "user" ή κάτι άλλο
            if ("user".equalsIgnoreCase(msg.getRole())) {
                springMessages.add(new UserMessage(msg.getContent()));
            } else {
                springMessages.add(new AssistantMessage(msg.getContent()));
            }
        }

        // 5. Κλήση στο DeepSeek στέλνοντας ολόκληρο το πακέτο μηνυμάτων
        return this.chatClient.prompt()
                .messages(springMessages)
                .call()
                .content();
    }
}