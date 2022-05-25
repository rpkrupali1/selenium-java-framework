This framework offers:

- Reusability
- Scalability
- Maintainability
- Understandability
- Workability
- As generic as possible (close to reusable for any application)
- Extendible (Should support web service testing, UI testing)
- Wrappable – does not depend on any of selenium version, we have our own controls

`"EVERYTHING SHOULD BE AS SIMPLE AS POSSIBLE, BUT NOT SIMPLER"`

- Albert Einstein

Page Object Model (POM)
- Reduce number of duplicate code
- Maintain object in separate class file
- Improve readability of code
- Handle each page using its instance
- Establish relation between each page

Created Base Abstract class rather than page initializing in every class, this makes code mich simpler and easy to understand.