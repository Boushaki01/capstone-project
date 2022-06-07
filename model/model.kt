val conditions = CustomModelDownloadConditions.Builder()
    .requireWifi()
    .build()
FirebaseModelDownloader.getInstance()
    .getModel("model", DownloadType.LOCAL_MODEL, conditions)
    .addOnCompleteListener {
      // Download complete. Depending on your app, you could enable the ML
      // feature, or switch from the local model to the remote model, etc.
    }