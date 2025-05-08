## Variables
Variables in Scala can be defined in 2 ways 

#### 1.Val keyword
a.These are immutable in nature meaning once you create a variable you cannot modify/update its value.

val fName="Naveen'
fName = "Arjun" // reassignment of value will throw an error
val lName = "kumar"

b. Variables names are defined in camelCasing(Ex: firstName and not first_name).

### 2.Var Keyword
a. when you want to define a variable where you can modify the value then define it using var keyword as shown below

var firstName="Naveen"

firstName = "Arjun" // reassignment of variable name will not throw exception

b. New assignment of value should be of same datatype otherwise it will throw error

var firstName="Naveen"

firstName= 1 // compiler error

Scala keep tracks of the data types assigned to a variable, the moment it encounters a change
in the data type, it will throw compilation error.
This is because Scala is Strongly typed language and type safety language.And its because of its 
type safety it will throw an exception

### But always start with val
Using val and var are the two ways to create variables in Scala. And now
that you’ve seen both approaches, it’s important to reiterate this point:
1. Always declare variables as val, unless
2. The variable really does need to vary over time, in which case you
   should create it as a var

### Explicitly declaring the variables
Scala is smart enough to detect the data type based on the variable value provided

val name:String = "Naveen"

There are 2 ways to create an integer as shown below

val input = 42 // Implicit data type detection by scala

val input:Int = 42 // explicit data type declaration







   

