import tkinter as tk
from tkinter import ttk, filedialog, messagebox
import pandas as pd
from Checker import remove_empty_and_surrounding_rows, analyze_visits, save_to_csv, read_excel, filter_by_time_frame

def main_gui():
    root = tk.Tk()
    root.title("Duplicate Checker")
    
    tk.Label(root, text="File:").pack()
    file_entry = tk.Entry(root, width=50)
    file_entry.pack()
    tk.Button(root, text="Select File", command=lambda: select_file_gui(file_entry)).pack()
    
    tk.Label(root, text="Save Folder:").pack()
    folder_entry = tk.Entry(root, width=50)
    folder_entry.pack()
    tk.Button(root, text="Select Folder", command=lambda: select_folder_gui(folder_entry)).pack()
    
    tk.Label(root, text="Select Time Frame").pack()
    time_frame_var = tk.StringVar(root)
    time_frame_var.set("1 Year") # Default value
    time_frame_options = ["1 Year", "6 Months", "3 Months", "1 Month", "All Time"]
    time_frame_dropdown = tk.OptionMenu(root, time_frame_var, *time_frame_options)
    time_frame_dropdown.pack()
    
    tk.Button(root, text="Process", command=lambda: process_file(file_entry, folder_entry, time_frame_var)).pack()
    tk.Button(root, text="View Data", command=lambda: view_data(file_entry, time_frame_var)).pack()
    
    root.mainloop()

def clean_data(file_path, time_frame_var):
    if not file_path:
        messagebox.showwarning("Warning", "Please select a file.")
        return
    df = read_excel(file_path)
    df_cleaned = remove_empty_and_surrounding_rows(df)
    df_filtered = filter_by_time_frame(df_cleaned, time_frame_var)
    return analyze_visits(df_filtered)

def select_file_gui(entry_widget):
    file_path = filedialog.askopenfilename()
    entry_widget.delete(0, tk.END)
    entry_widget.insert(0, file_path)

def select_folder_gui(entry_widget):
    folder_path = filedialog.askdirectory()
    entry_widget.delete(0, tk.END)
    entry_widget.insert(0, folder_path)

def process_file(file_entry, folder_entry, time_frame_var):
    df = clean_data(file_entry.get(), time_frame_var.get())
    save_folder = folder_entry.get()
    if not save_folder:
        messagebox.showwarning("Warning", "Please select a save folder.")
        return
    save_to_csv(df, save_folder)
    messagebox.showinfo("Success", "Analysis complete and saved.")

def view_data(file_entry, time_frame_var):
    file_path = file_entry.get()
    if not file_path:
        messagebox.showwarning("Warning", "Please select a file.")
        return
    
    df = clean_data(file_entry.get(), time_frame_var.get())
    if df is None:
        return
    
    df_filtered = df[df['Visited More Than Once'] == True]
    
    df_grouped = df_filtered.groupby('Name')['Date Requested'].apply(list).reset_index()
    df_grouped.loc[:, 'Dates Requested'] = df_grouped['Date Requested'].apply(lambda x: ', '.join([date.strftime('%Y-%m-%d') for date in x]))
    
    columns_to_display = ['Name', 'Dates Requested']
    df_display = df_grouped[columns_to_display]
    
    top = tk.Toplevel()
    top.title("Data Preview")
    tree = ttk.Treeview(top, columns=columns_to_display, show="headings")
    
    for col in columns_to_display:
        tree.heading(col, text=col)
        tree.column(col, anchor="center")

    for _i, row in df_display.iterrows():
        values_to_display = [row[col] for col in columns_to_display]
        tree.insert("", "end", values=values_to_display)
        
    tree.pack(expand=tk.YES, fill=tk.BOTH)

if __name__ == "__main__":
    main_gui()