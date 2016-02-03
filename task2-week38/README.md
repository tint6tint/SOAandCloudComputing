README: Week 38 - Web Service Clients
=====================================

Assignment for Introduction to SOA and Cloud Computing: 2 applications.

* **Authors**: Anggella Fortunato, David Galindo López, Shuhang Guo, Minna Lehtomäki, YanJun Liu
* **Licence**: GNU GPL 3.0


**Reflective questions:**
* *Most REST services do not use WSDL and SOAP. What could be reasons for this?*
According with the second question, SOAP and WSDL use XML, but XML needs too much tags for describe the contents.
For this reason, parsing XMLs files are slower and more inefficient than parsing other languages.

* *SOAP and WSDL use XML, would it be better if they would use something more modern like JSON?*
According with the first question, XMLs need too much tags for describe the contents.
However, JSON doesn't need a lot of tags for describe the contents. For this reason, parsing JSONs files are
easier, faster and more efficient than parsing XMLs files.

* *How did you handle errors and how should it be done? Imagine that your application is running on a production server.*
We need to do an application/function/script in the server part for validate the information and check that all is right.