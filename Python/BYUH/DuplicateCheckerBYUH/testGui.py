import tkinter as tk
from tkinter import filedialog, messagebox

def select_file_gui(entry_widget):
    file_path = filedialog.askopenfilename()
    entry_widget.delete(0, tk.END)  # Clear the existing content
    entry_widget.insert(0, file_path)  # Insert the selected file path

def select_folder_gui(entry_widget):
    folder_path = filedialog.askdirectory()
    entry_widget.delete(0, tk.END)
    entry_widget.insert(0, folder_path)

def process_file(file_entry, folder_entry):
    file_path = file_entry.get()
    save_folder = folder_entry.get()
    if not file_path or not save_folder:
        messagebox.showwarning("Warning", "Please select a file and a save folder.")
        return
    # Here, integrate your existing logic for processing the file
    # For example:
    # df = read_excel(file_path)
    # df_cleaned = remove_empty_and_surrounding_rows(df)
    # analyzed_df = analyze_visits(df_cleaned)
    # save_to_csv(analyzed_df, save_folder)
    messagebox.showinfo("Success", "Analysis complete and saved.")

def main_gui():
    root = tk.Tk()
    root.title("Spreadsheet Analysis")

    tk.Label(root, text="File Path:").pack()
    file_entry = tk.Entry(root, width=50)
    file_entry.pack()
    tk.Button(root, text="Select File", command=lambda: select_file_gui(file_entry)).pack()

    tk.Label(root, text="Save Folder:").pack()
    folder_entry = tk.Entry(root, width=50)
    folder_entry.pack()
    tk.Button(root, text="Select Folder", command=lambda: select_folder_gui(folder_entry)).pack()

    tk.Button(root, text="Process", command=lambda: process_file(file_entry, folder_entry)).pack()

    root.mainloop()

if __name__ == "__main__":
    main_gui()