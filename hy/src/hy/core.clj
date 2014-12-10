(ns hy.core
    (:use compojure.core)
    (:gen-class)
    (:require [compojure.handler :as handler]
                          [compojure.route :as route]
                          [aleph.http :refer [start-http-server wrap-ring-handler]]
                          [com.netflix.hystrix.core :refer [defcommand]]
                          [hystrix-event-stream-clj.core :as hystrix-event]))

(defcommand hello
              "Safe hello!"
              []
              "Hello world!")

(defroutes app-routes
             (GET "/" [] (hello))
             (GET "/hystrix.stream" [] (hystrix-event/stream))
             (route/resources "/")
             (route/not-found "Not Found"))

(def app
    (handler/site app-routes))

(defn -main
    []
    (start-http-server (wrap-ring-handler app) {:port (Integer. 5000)}))
