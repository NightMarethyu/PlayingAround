from django.contrib import admin

# Register your models here.
from .models import SimpleQuiz, SimpleQuestion, SimpleOptions

class ChoiceInline(admin.TabularInline):
    model = SimpleOptions
    extra = 2
    

class QuestionInline(admin.StackedInline):
    model = SimpleQuestion
    extra = 2
    list_display = ('order', 'title', 'prompt', 'choose_one', 'is_choice_limit', 'choice_limit')
    list_filter = ['order']
    
class QuestionAdmin(admin.ModelAdmin):
    inlines = [ChoiceInline]
    
class QuizAdmin(admin.ModelAdmin):
    inlines = [QuestionInline]
    search_fields = ['quiz_name']
    
admin.site.register(SimpleQuiz, QuizAdmin)
admin.site.register(SimpleQuestion, QuestionAdmin)