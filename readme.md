# Problem
In a Java code base there is a need for DTOs which are...
- ...immutable
- ...serializable and deserializable by Jackson
- ...documentable by Swagger
- ...cloneable changing selected fields only
- ...void of method code
# Comparison matrix
| Feature                             | Java Class+Lombok | Java Record | Kotlin |
|-------------------------------------|:-----------------:|:-----------:|:-------|
| Clone changing arbitrary fields     | YES               | NO          |  NO    |
| FasterXML-json (de/)serialize       | YES               | YES+        |  YES   |
| Inheritance hierarchy               | YES               | NO+         |  NO    |
| Reasonable toString(), equals, hash | YES               | YES+        |  YES   |
| Swagger annotations                 | YES               | NO          |  YES   |
- Assessments
    - YES : No code required (annotation possibly required)
    - YES+: Neither code nor annotation required
    - NO  : Impossible without added coding
    - NO+ : Can get somewhat closer than nothing
# The winner is: *Java class with Lombok*

# Nice to use
- mvn versions:display-dependency-updates