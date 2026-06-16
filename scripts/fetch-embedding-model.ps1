# Downloads the all-MiniLM-L6-v2 ONNX model (~90 MB) to a local path so the backend embeds offline
# (no startup download behind a corporate SSL proxy). Run ONCE from a machine with internet access,
# then ship/mount the resulting .\models dir to the server. The tokenizer.json is NOT needed — it
# already ships inside the spring-ai-transformers jar (loaded via classpath).
#
# Usage:  scripts\fetch-embedding-model.ps1 [-Dest <dir>]   (default: models\all-MiniLM-L6-v2)
param([string]$Dest = "models/all-MiniLM-L6-v2")

$ErrorActionPreference = "Stop"
# Spring AI's default ONNX model location (Git-LFS media URL = the real blob, not a pointer).
$Url = "https://media.githubusercontent.com/media/spring-projects/spring-ai/refs/heads/main/models/spring-ai-transformers/src/main/resources/onnx/all-MiniLM-L6-v2/model.onnx"

New-Item -ItemType Directory -Force -Path $Dest | Out-Null
$out = Join-Path $Dest "model.onnx"
Write-Host "Downloading model.onnx (~90 MB) -> $out"
Invoke-WebRequest -Uri $Url -OutFile $out

# Sanity check: a Git-LFS pointer is ~130 bytes; the real model is tens of MB.
$size = (Get-Item $out).Length
if ($size -lt 1000000) {
    Write-Error "Downloaded file is only $size bytes — likely an LFS pointer, not the model."
}
Write-Host ("Done ({0} MB). app.embedding.model-path already defaults to {1}." -f [int]($size / 1MB), $out)
