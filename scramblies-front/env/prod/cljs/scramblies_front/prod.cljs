(ns scramblies-front.prod
  (:require [scramblies-front.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
