from django.db import models

# Create your models here.
class SimpleQuiz(models.Model):
    quiz_name = models.CharField(max_length=200)
    
    def __str__(self):
        return self.quiz_name
    
class SimpleQuestion(models.Model):
    quiz = models.ForeignKey(SimpleQuiz, on_delete=models.CASCADE)
    order = models.IntegerField()
    choose_one = models.BooleanField(default=True)
    title = models.CharField(max_length=200)
    prompt = models.CharField(max_length=500)
    is_choice_limit = models.BooleanField(default=False)
    choice_limit = models.IntegerField(default=2)
    
    def __str__(self):
        return self.title
    
class SimpleOptions(models.Model):
    question = models.ForeignKey(SimpleQuestion, on_delete=models.CASCADE)
    option_text = models.CharField(max_length=200)
    points = models.IntegerField(default=1)
    
    def __str__(self):
        return self.option_text