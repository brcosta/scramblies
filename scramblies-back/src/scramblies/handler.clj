(ns scramblies.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [scramblies.service.scramblies :refer :all]
            [clojure.data.json :as json]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
           (GET "/" [] "ok")
           (GET "/scramblies*" {params :query-params}
             (json/write-str {:result (scramblies?
                                        (get params "str1")
                                        (get params "str2"))}))
           (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes site-defaults)
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-methods [:get])

  ))
