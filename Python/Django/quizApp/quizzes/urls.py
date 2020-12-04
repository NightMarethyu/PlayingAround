from django.urls import path

from . import views

app_name = 'quiz'
urlpatterns = [
    path('', views.index.as_view(), name='index'),
    path('<int:pk>/', views.detail.as_view(), name='detail'),
]
