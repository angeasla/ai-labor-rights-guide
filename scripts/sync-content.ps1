<#
.SYNOPSIS
    Sync the canonical Greek labor-rights markdown content into this backend repo
    as a category directory tree under src/main/resources/docs/.

.DESCRIPTION
    One-way mirror. Wipes the existing docs/ tree, then copies each category's
    *.md files (preserving each category's own index.md) plus the root index.md.
    Idempotent: safe to re-run; the destination is fully regenerated each time.

    Ignored at the source: .obsidian/, _templates/ (and the template file Article.md),
    and any non-.md files (e.g. publish.css). Only top-level *.md files inside each
    category directory are copied (no recursion into nested folders).

.PARAMETER Source
    Path to the canonical content/ directory.
    Default: worker-rights-guide\content

.EXAMPLE
    .\scripts\sync-content.ps1
    .\scripts\sync-content.ps1 -Source D:\path\to\worker-rights-guide\content
#>
[CmdletBinding()]
param(
    [string]$Source = 'worker-rights-guide\content'
)

$ErrorActionPreference = 'Stop'

# Resolve destination relative to this script: <repo>\scripts\ -> <repo>\src\main\resources\docs
$repoRoot = Split-Path -Parent $PSScriptRoot
$dest     = Join-Path $repoRoot 'src\main\resources\docs'

$categories = @('symvasi','orario','misthos','adeies','asfalisi','apolysi','syntaxi','ygeia','anergia')

if (-not (Test-Path -LiteralPath $Source)) {
    throw "Source content directory not found: $Source"
}

Write-Host "Source: $Source"
Write-Host "Dest:   $dest"

# Step 2: wipe the existing docs tree (full regeneration).
if (Test-Path -LiteralPath $dest) {
    Remove-Item -LiteralPath $dest -Recurse -Force
}
New-Item -ItemType Directory -Path $dest -Force | Out-Null

# Step 3: copy each category's top-level *.md (including its own index.md).
# robocopy flags: /NFL /NDL /NJH /NJS quiet output; /XD excludes ignored dirs;
# /XF excludes the Article.md template. We copy only the category dir's own *.md
# (non-recursive) so nested folders / .obsidian never leak in.
$grandTotal = 0
foreach ($cat in $categories) {
    $srcCat = Join-Path $Source $cat
    if (-not (Test-Path -LiteralPath $srcCat)) {
        Write-Warning "Category missing at source, skipping: $cat"
        continue
    }
    $dstCat = Join-Path $dest $cat
    New-Item -ItemType Directory -Path $dstCat -Force | Out-Null

    # robocopy: non-recursive (no /S), only *.md, exclude template + ignored dirs.
    robocopy $srcCat $dstCat '*.md' /XF 'Article.md' /XD '.obsidian' '_templates' /NFL /NDL /NJH /NJS /NP | Out-Null
    # robocopy exit codes 0-7 are success; >=8 is a real error.
    if ($LASTEXITCODE -ge 8) { throw "robocopy failed for category '$cat' (exit $LASTEXITCODE)" }

    $count = (Get-ChildItem -LiteralPath $dstCat -Filter *.md -File).Count
    $grandTotal += $count
    Write-Host ("  {0,-10} {1,3} files" -f $cat, $count)
}

# Root site home: content\index.md -> docs\index.md
$rootIndex = Join-Path $Source 'index.md'
if (Test-Path -LiteralPath $rootIndex) {
    Copy-Item -LiteralPath $rootIndex -Destination (Join-Path $dest 'index.md') -Force
    $grandTotal += 1
    Write-Host "  root index.md copied"
} else {
    Write-Warning "Root index.md not found at source: $rootIndex"
}

Write-Host ""
Write-Host "Sync complete. Total .md files: $grandTotal"

# robocopy uses non-zero "success" exit codes (1 = files copied). Normalise to 0
# so callers/CI don't mistake a successful sync for a failure.
exit 0
