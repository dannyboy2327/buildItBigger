# Gradle for Android and Java Final Project

In this project, I created an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The app consists
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What I Learned?

I learned the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. I learned to:

* Add free and paid flavors to an app, and set up a build to share code between them
* Factored reusable functionality into a Java library
* Factored reusable Android functionality into an Android library
* Configured a multi project build to compile libraries and app
* Used the Gradle App Engine plugin to deploy a backend
* Configured an integration test suite that runs against the local App Engine development server

## How Did I Complete this Project?

### Step 0: Starting Point

This is the starting point for the project, which is provided by
the [course repository](https://github.com/udacity/ud867/tree/master/FinalProject). It
contains an activity with a banner ad and a button that purports to tell a
joke, but actually just complains. The banner ad was set up with the following
instructions here:

https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start

I had to download the Google Repository from the Extras section of the
Android SDK Manager.

### Step 1: Create a Java library

First task was to create a Java library that provides jokes. Then created a new
Gradle Java project by using the Android Studio wizard. Then I
introduced a project dependency between my app and the new Java Library.

Then I made the button display a toast showing a joke retrieved from my Java joke
telling library.

### Step 2: Create an Android Library

I Created an Android Library containing an Activity that would display a joke
passed to it as an intent extra. Wired up the project dependencies so that the
button can now pass the joke from the Java Library to the Android Library.

### Step 3: Setup GCE

The next task was pretty tricky. Instead of pulling jokes directly from
my Java library, I set up a Google Cloud Endpoints development server,
and pulled my jokes from there.

Then I introduced a project dependency between my Java library 
and my GCE module, and then modified the GCE starter code to pull jokes from my Java library. 
Next I created an AsyncTask to retrieve jokes using the template included in this 
[instructions](https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend). 

Then I made the button kick off a task to retrieve a joke, 
then launched the activity from my Android Library to display it.


### Step 4: Add Functional Tests

Next I added code to test my Async task successfully retrieved a non-empty
string.

### Step 5: Add a Paid Flavor

Then I added free and paid product flavors to my app. I also removed the ad from the paid flavor.

