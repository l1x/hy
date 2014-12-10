(defproject hy "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
    [hystrix-event-stream-clj "0.1.3"]
  ]
 :jvm-opts [
  "-Xms1024m" "-Xmx2048m" "-server" 
  "-XX:+UseG1GC" "-XX:MaxGCPauseMillis=100" 
  "-XX:+TieredCompilation" "-XX:+AggressiveOpts"
  "-Dcom.sun.management.jmxremote"
  "-Dcom.sun.management.jmxremote.local.only=false"
  "-Dcom.sun.management.jmxremote.authenticate=false"
  "-Dcom.sun.management.jmxremote.ssl=false"
  ;"-Xprof" "-Xrunhprof"
 ]
  :main hy.core
)
