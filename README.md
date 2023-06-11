# String Comparator

### Project Definition
Given two strings s1 and s2, we want to visualize how different the two strings are. We will only
take into account the lowercase letters (a to z). First let us count the frequency of each lowercase
letter in s1 and s2.

s1 = "A aaaa bb c"
s2 = "& aaa bbb c d"
s1 has 4 'a', 2 'b', 1 'c'
s2 has 3 'a', 3 'b', 1 'c', 1 'd'

So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following
we will not consider letters when the maximum of their occurrences is less than or equal to 1.

We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1
in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner
2:bbb stands for string s2 and bbb because the maximum for b is 3.

The task is to produce a string in which each lowercase letter of s1 or s2 appears as many times as
its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number
of the string where they appear with their maximum value and :. If the maximum is in s1 as well as
in s2 the prefix is =:.

In the result, substrings will be in decreasing order of their length and when they have the same
length sorted alphabetically; the different groups will be separated by '/'.

### Prerequisites
- Java 17
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Docker](https://www.docker.com/)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)

### Tools
* IntelliJ IDEA (or any preferred IDE)
* Maven
* Postman (or any RESTful API testing tool)

### Build and Run application

Clone the project

```bash
  git clone https://github.com/kadirkaynak/string-comparator.git
```

Go to project directory

```bash
  cd string-comparator
```

Run the build.sh and start.sh script

```bash
   sh build.sh
   sh start.sh
```

### OpenApi Documentation

Open web browser and go to the swagger endpoint
>http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

### API Endpoints

- ### String Comparator
> **POST Mapping** http://localhost:8080/api/v1/string/comparator
>
~~~~
{
    "s1":"Are the kids at home? aaaaa fffff",
    "s2":"Yes they are here! aaaaa fffff"
}
