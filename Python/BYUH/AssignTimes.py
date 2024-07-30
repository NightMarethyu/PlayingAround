import csv
from tkinter import filedialog

# Venue constraints (adjust these numbers as needed)
venue_limits = {
    '8:00 AM': {'Endowment': 20, 'Baptisms': 30, 'Inititory': 25},
    '9:00 AM': {'Endowment': 20, 'Baptisms': 30, 'Inititory': 25},
    '10:00 AM': {'Endowment': 20, 'Baptisms': 30, 'Inititory': 25}
}

class Assignment:
    def __init__(self, time, ordinance):
        self.time = time
        self.ordinance = ordinance

class Student:
    def __init__(self, email, name, preferred_time, preferences, submission_time, recommend, isEndowed):
        self.email = email
        self.name = name
        self.preferred_time = preferred_time
        self.preferences = preferences
        self.submission_time = submission_time
        self.recommend = recommend
        self.isEndowed = isEndowed
        self.assignment = None
    
    def addAssignment(self, assignment):
        self.assignment = assignment
    
    def writeOut(self):
        return f"{self.name},{self.assignment.time},{self.assignment.ordinance},{self.email}"

def Main():
    # Read CSV and parse data
    submissions = []
    file_path = filedialog.askopenfilename()
    with open(file_path, mode='r', encoding='ISO-8859-1') as file:
        reader = csv.DictReader(file)
        for row in reader:
            preferences = row["RankOrdinances"].split(';')
            recommend = row['CurrentRecommend']  == 'Yes' if row['CurrentRecommend'] != '' else False
            isEndowed = row['isEndowed'] == 'Yes' if row['isEndowed'] != '' else False
            preffered_time = row['PreferredTime'] if row['PreferredTime'] != '' else '8:00 AM'
            student = Student(row["Email"], row["Name"], preffered_time, preferences, row["CompletionTime"], recommend, isEndowed)
            submissions.append(student)

    # Sort by submission time
    submissions.sort(key=lambda x: x.submission_time)

    for student in submissions:
        if not student.recommend:
            student.addAssignment(Assignment("8:00 AM", "Service Project"))
            continue
        if not student.isEndowed:
            student.addAssignment(Assignment(student.preferred_time, "Baptisms"))
            venue_limits[student.preferred_time]["Baptisms"] -= 1
            continue
        assigned = False
        for preference in student.preferences:
            if preference and venue_limits[student.preferred_time][preference] > 0:
                student.addAssignment(Assignment(student.preferred_time, preference))
                venue_limits[student.preferred_time][preference] -= 1
                assigned = True
                break
        if not assigned:
            print(f"Could not assign {student['Name']} to any preference at {student['PreferredTime']}")


    output_file_path = filedialog.asksaveasfilename(defaultextension=".csv", filetypes=[("CSV files", "*.csv")])
    with open(output_file_path, mode='w', newline='') as file:
        fieldnames = ['Email', 'Name', 'Assigned Time', 'Assigned Ordinance']
        writer = csv.DictWriter(file, fieldnames=fieldnames)
        
        writer.writeheader()
        for student in submissions:
            writer.writerow({'Email': student.email, 'Name': student.name, 'Assigned Time': student.assignment.time, 'Assigned Ordinance': student.assignment.ordinance})

if __name__ == '__main__':
    Main()

