import os

from flask import Flask, redirect, render_template, request, url_for
import json

from helpers import rescalc

app = Flask(__name__)

@app.route("/")
def index():
    with open('json/index.json') as f:
        data = json.load(f)
    
    return render_template("index.html", quizzes=data['quizzes'])

@app.route("/quiz/<quizName>")
def quiz(quizName):
    quizJson = quizName + '.json'
    with open('json/' + quizJson) as f:
        data = json.load(f)

    return render_template("quiz.html", data=data)

@app.route("/quiz/<quizName>/results", methods=["POST"])
def results(quizName):
    answers = []
    quizJson = quizName + '.json'
    with open('json/' + quizJson) as f:
        data = json.load(f)
    
    for q in data["questions"]:
        t = q["title"]
        ans = request.form.get(t)
        answers.append(ans)
    
    results = data["results"]
    
    temp = rescalc(quizName, answers, results)
    
    return render_template("results.html", res=temp)