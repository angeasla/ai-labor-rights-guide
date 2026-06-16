package com.angeasla.ai_labor_rights_guide.ratelimit;

import java.net.InetAddress;

/**
 * Minimal, dependency-free CIDR membership test for IPv4 and IPv6. Built once per configured shared
 * range at startup; {@link #matches(InetAddress)} is a cheap bitmask comparison on the address bytes.
 */
final class CidrMatcher {

    private final byte[] network;
    private final int prefixBits;

    private CidrMatcher(byte[] network, int prefixBits) {
        this.network = network;
        this.prefixBits = prefixBits;
    }

    /** Parse {@code "10.8.0.0/24"} or {@code "2001:db8::/32"} (a bare IP means /32 or /128). Returns null if invalid. */
    static CidrMatcher parse(String cidr) {
        try {
            String s = cidr.trim();
            int slash = s.indexOf('/');
            String ipPart = slash >= 0 ? s.substring(0, slash) : s;
            byte[] net = InetAddress.ofLiteral(ipPart).getAddress(); // literal only — never resolves DNS
            int maxBits = net.length * 8;
            int prefix = slash >= 0 ? Integer.parseInt(s.substring(slash + 1).trim()) : maxBits;
            if (prefix < 0 || prefix > maxBits) {
                return null;
            }
            return new CidrMatcher(net, prefix);
        } catch (RuntimeException e) {
            return null;
        }
    }

    boolean matches(InetAddress address) {
        byte[] addr = address.getAddress();
        if (addr.length != network.length) {
            return false; // IPv4 vs IPv6 family mismatch
        }
        int fullBytes = prefixBits / 8;
        for (int i = 0; i < fullBytes; i++) {
            if (addr[i] != network[i]) {
                return false;
            }
        }
        int remainingBits = prefixBits % 8;
        if (remainingBits != 0) {
            int mask = (0xFF << (8 - remainingBits)) & 0xFF;
            return (addr[fullBytes] & mask) == (network[fullBytes] & mask);
        }
        return true;
    }
}
