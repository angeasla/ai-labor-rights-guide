#!/usr/bin/env bash
#
# sync-content.sh
#
# Sync the canonical Greek labor-rights markdown content into this backend repo
# as a category directory tree under src/main/resources/docs/.
#
# One-way mirror. Wipes the existing docs/ tree, then copies each category's
# *.md files (preserving each category's own index.md) plus the root index.md.
# Idempotent: safe to re-run; the destination is fully regenerated each time.
#
# Ignored at the source: .obsidian/, _templates/ (and the template file Article.md),
# and any non-.md files (e.g. publish.css). Only top-level *.md files inside each
# category directory are copied (no recursion into nested folders).
#
# Usage:
#   scripts/sync-content.sh [SOURCE_CONTENT_DIR]
#
# SOURCE_CONTENT_DIR defaults to the canonical path below; override with arg 1
# or the SOURCE env var.
#
set -euo pipefail

DEFAULT_SOURCE='worker-rights-guide/content'
SOURCE="${1:-${SOURCE:-$DEFAULT_SOURCE}}"

# Resolve destination relative to this script: <repo>/scripts -> <repo>/src/main/resources/docs
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(dirname "$SCRIPT_DIR")"
DEST="$REPO_ROOT/src/main/resources/docs"

CATEGORIES=(symvasi orario misthos adeies asfalisi apolysi syntaxi ygeia anergia)

if [ ! -d "$SOURCE" ]; then
  echo "Source content directory not found: $SOURCE" >&2
  exit 1
fi

echo "Source: $SOURCE"
echo "Dest:   $DEST"

# Step 2: wipe the existing docs tree (full regeneration).
rm -rf "$DEST"
mkdir -p "$DEST"

have_rsync=0
if command -v rsync >/dev/null 2>&1; then have_rsync=1; fi

grand_total=0
for cat in "${CATEGORIES[@]}"; do
  src_cat="$SOURCE/$cat"
  if [ ! -d "$src_cat" ]; then
    echo "Category missing at source, skipping: $cat" >&2
    continue
  fi
  dst_cat="$DEST/$cat"
  mkdir -p "$dst_cat"

  if [ "$have_rsync" -eq 1 ]; then
    # Non-recursive: only top-level *.md, exclude template + ignored dirs.
    rsync -a --include='*.md' --exclude='Article.md' \
          --exclude='.obsidian/' --exclude='_templates/' --exclude='*' \
          "$src_cat"/ "$dst_cat"/
  else
    # Fallback to cp. nullglob so an empty match doesn't copy a literal '*.md'.
    shopt -s nullglob
    for f in "$src_cat"/*.md; do
      base="$(basename "$f")"
      [ "$base" = "Article.md" ] && continue
      cp "$f" "$dst_cat"/
    done
    shopt -u nullglob
  fi

  count=$(find "$dst_cat" -maxdepth 1 -type f -name '*.md' | wc -l | tr -d ' ')
  grand_total=$((grand_total + count))
  printf '  %-10s %3d files\n' "$cat" "$count"
done

# Root site home: content/index.md -> docs/index.md
if [ -f "$SOURCE/index.md" ]; then
  cp "$SOURCE/index.md" "$DEST/index.md"
  grand_total=$((grand_total + 1))
  echo "  root index.md copied"
else
  echo "Root index.md not found at source: $SOURCE/index.md" >&2
fi

echo ""
echo "Sync complete. Total .md files: $grand_total"
