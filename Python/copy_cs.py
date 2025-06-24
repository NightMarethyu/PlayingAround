import os
import sys

def copy_cs_contents_to_txt(root_dir, output_txt, exclude_dirs=None):
    if exclude_dirs is None:
        exclude_dirs = []

    with open(output_txt, 'w', encoding='utf-8') as outfile:
        for dirpath, dirnames, filenames in os.walk(root_dir):
            # Exclude specified directories
            dirnames[:] = [d for d in dirnames if os.path.relpath(os.path.join(dirpath, d), root_dir) not in exclude_dirs]
            for filename in filenames:
                if filename.endswith('.cs'):
                    file_path = os.path.join(dirpath, filename)
                    try:
                        with open(file_path, 'r', encoding='utf-8') as infile:
                            outfile.write(f'// File: {filename}\n')
                            outfile.write(infile.read())
                            outfile.write('\n\n')
                    except Exception as e:
                        print(f"Could not read {file_path}: {e}")

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python copy_cs_to_txt.py <root_dir> <output_txt> [<exclude_dir1> <exclude_dir2> ...]")
        sys.exit(1)

    root_directory = sys.argv[1]
    output_file = sys.argv[2]
    excluded_dirs = sys.argv[3:] if len(sys.argv) > 3 else None

    copy_cs_contents_to_txt(root_directory, output_file, excluded_dirs)
