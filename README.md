# android-training-2017

#<b>!Защита проектов 15 января!</b>

<b>If you have lessons at the university at same time with training and would like officially skip them on Monday, Thursday (18-21p.m.), please contact  Ivan_Ihnatsenka@epam.com</b>

Project for android training
Some changes

Project requirements:

0. Server App(for example)
1. Work with API (json, xml) example vk, facebook
2. Cache (DB)
3. View - hard example vk/facebook news feed
4. Threading
5. ImageLoader - no libraries! + File Cache + Memory Cache + Threadings
6. Flavors

*********************************************************
Link to common issues comment https://github.com/IstiN/android-training-2017/issues/154#issuecomment-344004988 

*********************************************************

#Review

Kiolk: https://github.com/Kiolk/BullsAndCows/compare/review?expand=1
Spaiker-grn: https://github.com/spaiker-grn/vk/commit/218269f5a384a0619b8b77a9aaf3ea546740284c

*********************************************************

How to see database.
http://facebook.github.io/stetho/
https://github.com/amitshekhariitbhu/Android-Debug-Database
#HW
1. Create database with few tables.
2. Put model to database.
3. Put model with related model to database.
4. Select data from database and convert to model.


#HW: 14.12.2017 - deadline (25.12.2017 23.59)
Buy notebook and take to next class


#HW: 23.11.2017 - deadline (13.12.2017 23.59)

Write own image loader (mem+file cache, configuration, request configuration etc.).


*********************************************************

*********************************************************
#HW: 20.11.2017 - deadline (30.11.2017 23.59)

1. RecyclerView (use GridLayoutManager, LinearLayoutManager) + (notify data set changed)+ ((optional) ItemDecoration)

2. Try to use GridView + ListView + Spinner + ViewPager

3. Pagination (RecyclerView)

4.*(optional) Drap and Drop or Swipe to Remove

#HW: 09.11.2017 - deadline (19.11.2017 23.59)

1. Implement threading in your own project (ex. load data feed)

or
 
  Create screen with text label and 3 buttons (Thread, AsyncTask, ExecutorService) and update label with value returned appropriate background worker.

*********************************************************

*********************************************************
#HW: 30.10.2017 - deadline (10.11.2017 23.59)

1. Layout your own 2 screens or Tweeter or Instagram main page

2. Attach screenshots to project README

*********************************************************

*********************************************************
#HW: 23.10.2017 - deadline (01.11.2017 23.59)

1. Create two fragments and interact between their using "Show" "Hide" method in FragmentTransaction

2. Start activity using Intent flags(Example authorization for lunchMode)

3. Create IntentService and send some data from BroadcastReceiver in activity

4.*(optional) Try create authorization for your future application(only UI)

*********************************************************


#Reviewed Android studio tools:
Project
Structure
TODO
Debug
Android Monitor
  logcat
  layout inspecter
  screen capture
  memory monitors
  memory dump
  cpu monitor
  network monitor
  method profiler (Tools->Android->Android device monitor)
Terminal

Lint (Analyze->Inspect code...)

Reviewed Android tools:
Layout bounds
Strict mode
Don't keep activities
GPU Overdraw

https://developer.android.com/guide/topics/resources/providing-resources.html
hotkey promoter plugin - https://plugins.jetbrains.com/plugin/4455-key-promoter
Note. That lesson without homework


#HW: 16.10.2017 - deadline (25 Oct. Sunday 23.59)
1. create merge request to fix tests in training project
2. to create example with Mockito @Captor (ArgumentCaptor<Callback<Long>>)
3. doReturn example for mockito
4. create backend that will return config JSON with following information:  current_app_version(1,2,3...) compare with BuildConfig.VERSION_CODE, force_update(true - show dialog to upgrade without option to close, false - show dialog that update available with option to close)
5. create separate backends for debug and release version
6. create Google Play flavor and Amazon flavor
7. separate config for Google Play and for Amazon



#HW: 12.10.2017 - deadline (18 Oct. Sunday 23.59)
1. Create and deploy backend module to the Google App Engine
2. Save and get some information from your API through app and html page(for example: you can set two numbers, do some operation on backend, and return result )
3. (For reading)*
 
   GCM(https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/GcmEndpoints)
   
   Servlet(you can create the same backend module using servlet https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld)
   
   Firebase(https://cloud.google.com/solutions/mobile/firebase-app-engine-android-studio)
   
   **NOTE: Please when you create new issue with homework please provide link on compare ( you need add /compare to your main git link f.e. https://github.com/IstiN/android-training-2017/compare ) and do choice two commits.**

#HW: 09.10.2017 - deadline (15 Oct. Sunday 23.59)
1. create interface for HttpClient and mock it
2. prepare responses with jsonObject and jsonArray
3. parse responses over JSONObject/JSONArray
4. parse responses over GSON
5. convert time from'registered' field to friendly value over GSON Type adapter. For example 1507582371121 to 09 Oct 2017, 20:52:51. If your response don't contain UNIX time, you can convert any other field

cover parsing by test

sample json file added to project (generated.json)

#HW: 05.10.2017 - deadline (11 Oct. Wednesday 23.59)
1. setup roboelectric, mockito
2. develop some business logic (for example calculator or part of logic from your future project)
3. cover it by unitTest(mockito, robolectric) and instrumentationTest (espresso). HW should contain examples of mock, spy, activityLifecycleMock with robolectric.


#HW: 02.10.2017 - deadline (8 Oct. Sunday 23.59)

1. Create project (github || bitbucket), soursetree
2. Push Android Project to master in repo (.gitignore)
3. Create 'feature_1', 'feature_n' branches
4. Push all branches to remote
5. Emulate conflict in a few files
6. Merge conflict to master
7. Chery Pick
8. Rebase
9. Stash
10. Tags
11. Submodules

links:

https://habrahabr.ru/post/106912/

#old one

https://github.com/deniotokiari/training-epam-2016
