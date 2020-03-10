(ns curso.aula5)

(println estoque)
(println "Temos:" (count estoque) "elementos")
(println "As chaves são:" (keys estoque))
(println "As valores são:" (vals estoque))

(def estoque {:mochila  10
              :camiseta 5
              })

(defn tira-um
  [x]
  (println "subtraindo um")
  (- x 1))

(println estoque)
(println "Adicionando o elemento :cadeira" (assoc estoque :cadeira 3))
(println estoque)
(println "Removendo um elemento" (dissoc estoque :mochila))
(println estoque)
(println "atualizando valor de um elemento" (update estoque :mochila inc))
(println estoque)
(println (update estoque :camiseta tira-um))

(def pedido {
             :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             })

(def pedido (assoc pedido :chuveiro 1, :preco 10))

(println "\n\n\n\n")
(println pedido)

; Raramente usado, pois se o elemento nao existir sera apresentado NullPointerException
(println (pedido :mochila))

; Pode ser usado para que fique explicito que é um get
(println (get pedido :mochila))

; Os mais usado, pois se o elemento n existir ele retorna nil
(println (:mochila pedido))
(println (:cadeira pedido {}))


; Atualizando um item dentro de um Map
(println (update-in pedido [:mochila :quantidade] inc))

; ACESSANDO UM ELEMENTO DE UM MAPA
(println (:quantidade (pedido :mochila)))

; FORMA MAIS USADA: THREADING FIRST
(println (-> pedido
             :mochila
             :quantidade))






