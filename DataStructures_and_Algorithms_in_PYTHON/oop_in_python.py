"""
> Class is a blueprint for an object.
> Self keyword passes the reference of the object is was called from automatically.
> Self allows us to access the object attributes and methods linked to that object.


> Everytime an object calls a method it always passed its own object reference.
class Test:
    def __init__(): 
        self.attribute = 0
    def test_func():
        return self.attribute
obj = Test()
obj.test_func() 
### This will give an error as test_func will pass obj's reference 
### to the function but since the function wont accept any arguments.
"""

####################################################################################################
####################################################################################################
####################################################################################################
##### General Structure of Class:
print(f'{"#"*50} General Structure of Class:')

class Dog:
    def __init__(self, name="Name Less", age=-1):
        self.name = name
        self.age = age
        
    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def set_name(self, new_name):
        self.name = new_name

    def set_age(self, new_age):
        self.name = new_age

    def bark(self):
        print('Bark')

d = Dog("Leo", 6)
d.bark()
print(type(d))
print(d.get_name())
print(d.get_age())

####################################################################################################
####################################################################################################
####################################################################################################
##### General Usecase for Classes:
print(f'{"#"*50} General Usecase for Classes:')

class Student:
    def __init__(self, name, age, grade):
        self.name = name
        self.age = age
        self.grade = grade

    def get_grade(self):
        return self.grade

class Course:
    def __init__(self, name, max_students):
        self.name = name
        self.max_students = max_students
        self.students = []

    def add_student(self, student):
        if len(self.students) < self.max_students:
            self.students.append(student)
            return True
        return False
    
    def get_average_grade(self):
        grades = 0
        for student in self.students:
            grades += student.get_grade()
        return grades / len(self.students)

s1 = Student('Anurag', 19, 95)
s2 = Student('Abhishek', 20, 91)
s3 = Student('Panda', 17, 87)
s4 = Student('Zealot', 19, 79)
s5 = Student('Tim', 91, 66)

course = Course('Computers', 3)
print(course.add_student(s1))
print(course.add_student(s2))
print(course.add_student(s4))
print(course.add_student(s3))
print(course.get_average_grade())

####################################################################################################
####################################################################################################
####################################################################################################
##### Inheritence:
print(f'{"#"*50} Inheritence:')

class Pet:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def set_name(self, new_name):
        self.name = new_name

    def set_age(self, new_age):
        self.name = new_age

    def show(self):
        print(f'I am {self.get_name()} and I am {self.get_age()} years')

    def speak(self):
        print(f'I dont know that to speak.')

class Dog(Pet): # Dog class inherits from Pet class
    # It will override Pet.speak().
    def speak(self):
        print('Bark')

class Cat(Pet): # Cat class inherits from Pet class
    def __init__(self, name, age, color):
        # super() if a reference to the super class that is automatically created once Cat is created.
        super().__init__(name, age)
        self.color = color

    # It will override Pet.show().
    def show(self):
        super().show() # Pet.show() can still be accessed like this.
        print(f'I am {self.get_name()} and I am {self.get_age()} years and I am {self.color}.')

    # It will override Pet.speak().
    def speak(self):
        print('Meow')

class Fish(Pet): # Fish class inherits from Pet class
    pass

p = Pet('Leo', 6)
d = Dog('Ricky', 8)
c = Cat('Tom', 4, 'Grey')
f = Fish('Bubbles', 1)

p.show()
d.show() # Dog doesnt have __init__() and show()
c.show() # Cat doesnt have __init__() and show()   
f.show()
p.speak()
d.speak()
c.speak()
f.speak()

####################################################################################################
####################################################################################################
####################################################################################################
##### Class & Instance Attributes:
print(f'{"#"*50} Class & Instance Attributes/Methods:')

class Person:
    number_of_people = 0

    def __init__(self, name):
        self.name = name
        # Person.number_of_people += 1
        Person.add_person()

    @classmethod
    def get_number_of_people(cls):
        return cls.number_of_people

    @classmethod
    def add_person(cls):
        cls.number_of_people += 1

    @staticmethod
    def add5(x):
        return x + 5

    @staticmethod
    def add10(x):
        return x + 10


p1 = Person("Anurag")
p2 = Person("Abhishek")

print(p1.number_of_people)
print(p2.number_of_people)
p1.number_of_people += 1 # This won't work, as number_of_people is not an attribute of p1 object.
Person.number_of_people += 1 # This works, as number_of_people is an attribute of Person Class.
print(p1.number_of_people)
print(p2.number_of_people)

print(Person.get_number_of_people())
Person.add_person()
print(Person.get_number_of_people())

print(Person.add5(100))
