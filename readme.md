# Comparison matrix
**Immutability is assumed in all cases below:**
<BR/>YES : No code required (annotation possibly required)
<BR/>YES+: Neither code nor annotation required
<BR/>NO  : Impossible without added coding  
<BR/>NO+ : Can get somewhat closer than nothing

| Feature                             |      Class+Lombok      |  Record | Kotlin |
|-------------------------------------|:----------------------:|:-------:|:-------|
| Clone changing arbitrary fields     | YES                    | NO      |        |
| FasterXML-json (de/)serialize       | YES                    | YES+    |        |
| Inheritance hierarchy               | YES                    | NO+     |        |
| Reasonable toString(), equals, hash | YES                    | YES+    |        |
| Swagger annotations                 | YES                    | NO      |        |

# Nice to use
- mvn versions:display-dependency-updates