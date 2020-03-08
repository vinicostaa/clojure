(ns curso.aula3)

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de " desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))
(println (valor-descontado 100))

; PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    valor-bruto))

(println (valor-descontado 1000))
(println (valor-descontado 100))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; anonymous function
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))

; anonymous function simple syntax
(println (valor-descontado #(> % 100) 1000))

; call function with defn
(println (valor-descontado mais-caro-que-100? 100))














