from django.http import HttpResponse
from django.shortcuts import render
from django.views import generic

from .models import SimpleQuiz, SimpleQuestion, SimpleOptions

# Create your views here.
class index(generic.ListView):
    template_name = 'quizzes/index.html'
    context_object_name = 'quizzes_list'
    
    def get_queryset(self):
        return SimpleQuiz.objects.order_by('quiz_name')

class detail(generic.DetailView):
    model = SimpleQuiz
    template_name = 'quizzes/detail.html'
    
    def get_queryset(self):
        return SimpleQuiz.objects
    