**NASA Mobile Application:**

_Libraries Used:_
okhttp3 - sending and receiving GET requests and responses in JSON format
picasso - set image URLs to ImageView of layouts
espresso, mockito, junit - for debugging/unit testing

_App Architecture:_
MainActivity.java - first program/display on boot, displays search bar and scrollable search results
MainActivity2.java - displays when a search result button is clicked, displaying more details of result
SearchResult.java - defines search result object used to organize JSON data from GET response  
RecyclerViewAdapter.java/RecyclerViewInterface.java - defines recycler view display and actions on click

activity_main.xml, activity2_main.xml, recyclerview_row.xml - defined layout of each part of app

_How to Build App:_

__On terminal:__ 

_On Windows:_
gradlew app

_On Mac/Linux:_
(if necessary): chmod +x gradlew
./gradlew app

__On Android Studio:__
1. Open NASA Search Engine App
2. Click the green hammer on the top bar

_How to Run App:_

__On Android Studio:__
1. Select the proper files to run (app) and customize emulator or device of your choice.
2. Click Green play button on right hand side of top bar.


