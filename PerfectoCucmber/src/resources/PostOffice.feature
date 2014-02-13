Feature: Post office
 
  @Postoffice 
  Scenario: look for zip code 
  Given check for address "newton,MASSACHUSETTS,02459" 
   When looking for zip code
   Then get the "02459"
   
