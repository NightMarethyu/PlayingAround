import json

with open('json/index.json') as f:
    data = json.load(f)
    
for quiz in data["quizzes"]:
    print(quiz["title"])