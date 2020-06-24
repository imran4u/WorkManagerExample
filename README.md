# WorkManager Example

** Work manager **
- easy to schedule deferrable, asynchronous tasks that are expected to run even if the app exits or the device restarts
- The WorkManager API is a suitable and recommended replacement for all previous Android background scheduling APIs, including FirebaseJobDispatcher, GcmNetworkManager, and Job Scheduler.
- WorkManager incorporates the features of its predecessors in a modern, consistent API that works back to API level 14 while also being conscious of battery life.

** Classes **
- <b>Worker:</b> The work need to be done will define here in method `doWork()`
- <b>WorkRequest:</b> It define work, which worker class is going to execute
    - OneTimeWorkRequest
    - PeriodicWorkRequest
- <b>WorkManager:</b> Enqueue and manages work request
- <b>WorkInfo:</b> It contian information about work



Under the hood WorkManager uses an underlying job dispatching service based on the following criteria:
<a href="https://developer.android.com"><img src="https://developer.android.com/images/topic/libraries/architecture/workmanager/overview-criteria.png"></a>

Ref:-
https://developer.android.com/topic/libraries/architecture/workmanager
