Java.perform(function(){
  var QZoneHelper = Java.use("cooperation.qzone.QZoneHelper");
  var QZoneHelper$UserInfo = Java.use("cooperation.qzone.QZoneHelper$UserInfo");
  var ActivityThread = Java.use('android.app.ActivityThread');
  var Context = Java.use('android.content.Context');
  var ctx = Java.cast(ActivityThread.currentApplication().getApplicationContext(), Context);
  QZoneHelper.forwardToUserHome(ctx,QZoneHelper$UserInfo.getInstance(),"