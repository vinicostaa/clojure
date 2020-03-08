(ns curso.aula4)

(def precos [30, 700, 1000])

(println
  "accessing first element"
  (precos 0))

;return error if access index nil
;(println (precos 10))

; get function
(println
  "get second element in array"
  (get precos 1))

(println
  "get function return nil if not exist in array"
  (get precos 10))

(println
  "get function return default value if not exist request index"
  (get precos 10 10))

; update
(println
  "update first element in array"
  (update precos 0 inc))


(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println
  "map"
  (map valor-descontado precos))

(println
  "range"
  (filter even? (range 10)))

(println
  "filter"
  (filter aplica-desconto? precos))


(defn minha-soma
  [valor-1 valor-2]
  (+ valor-1 valor-2))


(println
  "first value + secund value..."
  (reduce minha-soma precos))


(println
  "return first value"
  (reduce minha-soma [15]))

; exception
;(println (reduce minha-soma []))

(println
  "return default value 0"
  (reduce minha-soma 0 []))





