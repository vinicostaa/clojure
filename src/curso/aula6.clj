(ns curso.aula6)

(def pedido {
             :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             })

(defn imprime-e-15
  [valor]
  (println "valor" (class valor) valor)
  15)

; Percorrendo um MAP
;(println (map imprime-e-15 pedido))

; Percorrendo e desestruturando
(defn imprime-e-15
  [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos
  [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))

(defn total-dos-produtos
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-dos-produtos pedido))


; THREAD LAST, parametro é passado no final
(defn total-de-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos,,,)
       (reduce +,,,)))

(println (total-dos-produtos pedido))

; Melhor forma THREAD LAST
(defn preco-total-dos-produtos
  [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-de-pedido
  [pedido]
  (->> pedido
       vals                                                 ; retorna os valores da chave passada por parametro
       (map preco-total-dos-produtos,,,)
       (reduce +,,,)))

(println (total-dos-produtos pedido))

(def pedido {
             :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}
             })

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (map gratuito? (vals pedido)))
(println (filter gratuito? (vals pedido)))


(println "Filtrando gratuitos")
(println (filter (fn [[_ item]] (gratuito? item)) pedido))

(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))


(def clientes [
               { :nome "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo"
                :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela"
                :certificados ["Arquitetura" "Gastronomia"] }])


(defn total-certificados-cliente
  [cliente]
  (count (:certificados cliente)))

(println "total certificados por cliente" (map total-certificados-cliente clientes))

(defn total-certificados
  [clientes]
  (->> clientes
       (map total-certificados-cliente)
       (reduce +)))

(println (total-certificados clientes))


