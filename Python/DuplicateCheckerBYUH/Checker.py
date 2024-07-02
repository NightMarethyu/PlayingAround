from datetime import timedelta, datetime
import pandas as pd
from tkinter import Tk, filedialog

def select_file():
    root = Tk()
    root.withdraw()
    try:
        file_path = filedialog.askopenfilename()
        if not file_path:
            print("File Selection Cancelled.")
            return None
        return file_path
    except Exception as e:
        print(f"Error selecting file: {e}")
        return None

def read_excel(file_path):
    try:
        return pd.read_excel(file_path, skiprows=2)
    except Exception as e:
        print(f"Error reading file: {e}")
        return None

def remove_empty_and_surrounding_rows(df):
    try:
        # Find indices of all rows that are entirely empty
        empty_rows = df.index[df.isna().all(axis=1)].tolist()
        
        # Calculate indices to remove: the empty row, one before, and one after
        indices_to_remove = set()
        for index in empty_rows:
            if index > 0:  # Ensure index-1 is within bounds
                indices_to_remove.add(index - 1)
            indices_to_remove.add(index)
            if index < len(df) - 1:  # Ensure index+1 is within bounds
                indices_to_remove.add(index + 1)
            if index < len(df) - 2:  # Ensure index+2 is within bounds
                indices_to_remove.add(index + 2)
        
        # Remove rows at these indices
        cleaned_df = df.drop(indices_to_remove)
        
        return cleaned_df.reset_index(drop=True)
    except Exception as e:
        print(f"Error cleaning data: {e}")
        return df

def analyze_visits(df):
    try:
        df.loc[:, 'Name'] = df['Name'].str.lower()
        df.loc[:, 'Visited More Than Once'] = df.duplicated('Name', keep=False)
        visit_counts = df['Name'].value_counts().reset_index()
        visit_counts.columns = ['Name', 'Visit Count']
        return df.merge(visit_counts, on='Name')
    except Exception as e:
        print(f"Error analyzing data: {e}")
        return df

def save_to_csv(df, directory):
    try:
        save_path = f'{directory}/visit_analysis.csv'
        df.to_csv(save_path, index=False)
    except Exception as e:
        print(f"Error saving data: {e}")

def filter_by_time_frame(df, time_frame_var):
    df['Date Requested'] = pd.to_datetime(df['Date Requested'], errors='coerce')
    current_date = datetime.now()
    if time_frame_var == "1 Year":
        return df[df['Date Requested'] >= current_date - timedelta(days=365)]
    elif time_frame_var == "6 Months":
        return df[df['Date Requested'] >= current_date - timedelta(days=180)]
    elif time_frame_var == "3 Months":
        return df[df['Date Requested'] >= current_date - timedelta(days=90)]
    elif time_frame_var == "1 Month":
        return df[df['Date Requested'] >= current_date - timedelta(days=30)]
    else:
        return df

def main():
    file_path = select_file()
    if file_path is None:
        return
    df = read_excel(file_path)
    if df is None:
        return
    df_cleaned = remove_empty_and_surrounding_rows(df)
    analyzed_df = analyze_visits(df_cleaned)
    if analyzed_df is None:
        return
    save_folder = filedialog.askdirectory()
    if not save_folder:
        print("Save folder selection cancelled.")
        return
    save_to_csv(analyzed_df, save_folder)
    print("Analysis complete and saved.")

if __name__ == "__main__":
    main()