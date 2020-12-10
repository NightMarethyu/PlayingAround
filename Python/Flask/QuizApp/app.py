import os

from flask import Flask, redirect, render_template, request, url_for, abort
import json

from helpers import rescalc

app = Flask(__name__)

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/about")
def about():
    return render_template("about.html")

@app.route("/quizzes")
def quizzes():
    try:
        with open('json/quizzes.json') as f:
            data = json.load(f)
    except:
        abort(404)
    
    return render_template("quizzes.html", quizzes=data['quizzes'])

@app.route("/quiz/<quizName>")
def quiz(quizName):
    quizJson = quizName + '.json'
    try:
        with open('json/' + quizJson) as f:
            data = json.load(f)
    except:
        abort(404)

    return render_template("quiz.html", data=data)

@app.route("/quiz/<quizName>/results", methods=["POST"])
def results(quizName):
    answers = []
    quizJson = quizName + '.json'
    
    try:
        with open('json/' + quizJson) as f:
            data = json.load(f)
    except:
        abort(404)
    
    for q in data["questions"]:
        t = q["title"]
        ans = request.form.get(t)
        answers.append(ans)
    
    results = data["results"]
    
    temp = rescalc(quizName, answers, results)
    
    return render_template("results.html", res=temp)

@app.errorhandler(404)
def page_not_found(e):
    return render_template('404.html'), 404

