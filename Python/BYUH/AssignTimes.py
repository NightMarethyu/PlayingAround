import csv
from tkinter import filedialog

# Venue constraints (adjust these numbers as needed)
venue_limits = {
    '8:00 am': {'Endowment': 20, 'Baptisms': 30, 'Initiatory': 25},
    '9:00 am': {'Endowment': 20, 'Baptisms': 30, 'Initiatory': 25},
    '10:00 am': {'Endowment': 20, 'Baptisms': 30, 'Initiatory': 25}
}

# Read CSV and parse data
students_preferences = []
file_path = filedialog.askopenfilename()
with open(file_path, mode='r', encoding='utf-8') as file:
    reader = csv.DictReader(file)
    for row in reader:
        preferences = row['Rank the ordinances in order of what you want to do'].split(';')
        students_preferences.append({
            #'ID': row['ID'],
            'Email': row['Email'],
            'Name': row['Full name'],
            'Preferred Time': row['Preferred Time'],
            'Preferences': preferences,
            'Submission Time': row['Start time']
        })

# Sort by submission time
students_preferences.sort(key=lambda x: x['Submission Time'])

# Schedule assignments
assignments = []

for student in students_preferences:
    assigned = False
    for preference in student['Preferences']:
        if preference and venue_limits[student['Preferred Time']][preference] > 0:
            assignments.append({
                #'ID': student['ID'],
                'Name': student['Name'],
                'Time': student['Preferred Time'],
                'Ordinance': preference
            })
            venue_limits[student['Preferred Time']][preference] -= 1
            assigned = True
            break
    if not assigned:
        print(f"Could not assign {student['Name']} to any preference at {student['Preferred Time']}")

# Output the schedule (for simplicity, printing it)
print(f"Name\t\t\t\tTime\t\tOrdinance")
for assignment in assignments:
    print(f"{assignment['Name']}\t{assignment['Time']}\t\t{assignment['Ordinance']}")