# Comparison matrix
- Assumed in all cases below:
  - Immutability is assumed
  - Call from Java is assumed
- Assessments
  - YES : No code required (annotation possibly required)
  - YES+: Neither code nor annotation required
  - NO  : Impossible without added coding  
  - NO+ : Can get somewhat closer than nothing

| Feature                             | Java Class+Lombok | Java Record | Kotlin |
|-------------------------------------|:-----------------:|:-----------:|:-------|
| Clone changing arbitrary fields     | YES               | NO          |  NO    |
| FasterXML-json (de/)serialize       | YES               | YES+        |  YES   |
| Inheritance hierarchy               | YES               | NO+         |  NO    |
| Reasonable toString(), equals, hash | YES               | YES+        |  YES   |
| Swagger annotations                 | YES               | NO          |  YES   |

# Nice to use
- mvn versions:display-dependency-updates