 rpc.exports = {
     init: function (stage, parameters) {
       console.log('[init]', stage, JSON.stringify(parameters));






Interceptor.attach(Module.getExportByName("libc.so", 'open'), {
                onEnter: function (args) {


                          var path = args[0].readUtf8String();
                                                  console.log('open("' + path + '")'+JSON.stringify(args));


                }
              });
Module.ensureInitialized("libaudioflinger.so")


//                var id = null;
//                var flag = false;
               Interceptor.attach(Module.getExportByName(null, 'open'), {
                       onEnter: function (args) {
//                        this.flag = false;
                         var path = args[0].readUtf8String();
                        console.log('.open("' + path + '")');
                       }
                     });
          Interceptor.attach(Module.getExportByName(null, 'read'), {
                onEnter: function (args) {

//    console.log('Context  : ' + JSON.stringify(this.context));


                        if(args[0].toInt32()==id)
                        {
                                console.log('read(pcm)'+JSON.stringify(args));
                          }



                }
              });
     },
     dispose: function () {
       console.log('[dispose]');
     }
   };

Console.log("helloword");