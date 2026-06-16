#!/usr/bin/env bash
# Downloads the all-MiniLM-L6-v2 ONNX model (~90 MB) to a local path so the backend embeds offline
# (no startup download behind a corporate SSL proxy). Run ONCE from a machine with internet access,
# then ship/mount the resulting ./models dir to the server. The tokenizer.json is NOT needed — it
# already ships inside the spring-ai-transformers jar (loaded via classpath).
#
# Usage:  scripts/fetch-embedding-model.sh [dest-dir]   (default: models/all-MiniLM-L6-v2)
set -euo pipefail

DEST="${1:-models/all-MiniLM-L6-v2}"
# Spring AI's default ONNX model location (Git-LFS media URL = the real blob, not a pointer).
URL="https://media.githubusercontent.com/media/spring-projects/spring-ai/refs/heads/main/models/spring-ai-transformers/src/main/resources/onnx/all-MiniLM-L6-v2/model.onnx"

mkdir -p "$DEST"
echo "Downloading model.onnx (~90 MB) -> $DEST/model.onnx"
curl -fL "$URL" -o "$DEST/model.onnx"

# Sanity check: a Git-LFS pointer is ~130 bytes; the real model is tens of MB.
size=$(wc -c < "$DEST/model.onnx")
if [ "$size" -lt 1000000 ]; then
  echo "WARNING: downloaded file is only $size bytes — likely an LFS pointer, not the model." >&2
  exit 1
fi
echo "Done ($((size / 1024 / 1024)) MB). Point app.embedding.model-path at $DEST/model.onnx (default already does)."
