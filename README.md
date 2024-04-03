##  Visão geral
O sistema de software oferece recursos para classificar imagens de personagens do programa de televisão Os Simpsons. Os usuários interagem por meio de uma interface web construída com modelos Spring MVC e Thymeleaf. Na página inicial, eles podem fazer upload de uma imagem representando um personagem dos Simpsons por meio de um formulário de upload de arquivo.
Depois de enviada, a imagem é passada para um serviço de back-end que utiliza técnicas de visão computacional para extrair características numéricas. Este processo analisa o conteúdo dos pixels, detectando cores e objetos para produzir um vetor característico que encapsula o perfil visual da imagem. Por exemplo, ele pode detectar as porcentagens de pixels laranja, azul e cinza correspondentes a artigos de vestuário.
As características numéricas são então inseridas em um modelo de aprendizado de máquina Naive Bayes pré-treinado. Este modelo foi otimizado através de dados de treinamento para classificar imagens com base em características visuais. Ele analisa o vetor de entrada e gera uma distribuição de probabilidade indicando qual personagem dos Simpsons a imagem provavelmente representa. O caractere com maior probabilidade é retornado e exibido ao usuário junto com as características extraídas.
O aplicativo é construído em Spring Boot, que cuida da configuração e inicialização do servidor web. Isso permite o rápido desenvolvimento dos recursos de aprendizado de máquina em um aplicativo Web pronto para produção. Por meio dessa interface intuitiva, os usuários podem classificar facilmente as imagens dos personagens dos Simpsons, aproveitando a visão computacional automatizada e as técnicas de aprendizado de máquina.

## Características
* O sistema permitirá que os usuários carreguem arquivos de imagem por meio de um formulário web.
* O sistema processará e analisará arquivos de imagem carregados em formatos padrão como JPG, PNG, etc.
* O sistema deve otimizar e pré-processar imagens para prepará-las para análise de pixels.
* O sistema analisará programaticamente as cores dos pixels e os objetos na imagem.
* O sistema calculará a porcentagem ou proporção do total de pixels da imagem com características específicas.
* O sistema deve encapsular características e rótulos extraídos em objetos de transferência de dados.
* O sistema deverá fornecer uma interface para classificação de imagens com base nas características extraídas.
* O sistema deverá utilizar um modelo de aprendizado de máquina Naive Bayes para classificar as características da imagem.
* O sistema deverá possuir um conjunto de dados de treinamento com exemplos rotulados para construir o modelo de classificação.
* O sistema classificará as imagens em rótulos conhecidos com base nas características extraídas.
* O sistema deve retornar os resultados da classificação ao usuário como respostas JSON.
* O sistema atualizará a exibição da web dinamicamente para mostrar os resultados da classificação.
* O sistema deverá utilizar modelos modulares para uma estrutura de página consistente.
* O sistema deve usar JavaScript para atualizações dinâmicas de páginas e comunicação assíncrona.
* O sistema deve expor uma API REST por meio de um backend Spring MVC.
* O sistema deve aproveitar o Spring Boot para inicialização e configuração do aplicativo.
* O sistema deve se conectar a um banco de dados MySQL usando Spring Data JPA.
* O sistema deve externalizar a configuração por meio das propriedades do Spring Boot.
* O sistema deve registrar erros e exceções com rastreamentos de pilha.
* O sistema deverá possuir testes automatizados para validação de startup e integração.

## Entidades
* Imagem: Uma imagem digital enviada pelo usuário para ser classificada. Ele contém dados visuais de pixels que são analisados.
* Característica: Uma representação numérica de atributos visuais extraídos da imagem, como histogramas coloridos. Eles formam o vetor de recursos.
* Classificação: O processo de análise das características de uma imagem para determinar qual personagem dos Simpsons ela representa.
* Classificador: O modelo de aprendizado de máquina que realiza a classificação, implementado aqui com Naive Bayes.
* Controlador: o componente da web que lida com solicitações de upload e classificação de imagens.
* Serviço: Componentes que encapsulam a lógica para extrair dados de imagens e classificar imagens.
* Modelo: Classes que representam dados como as características extraídas.
* Subsistemas
* Processamento de imagem
* O subsistema de processamento de imagens fornece funcionalidade para extrair dados significativos de imagens enviadas pelo usuário. Ele converte os pixels brutos da imagem em representações numéricas que capturam características visuais como perfis de cores e formas de objetos. Isso permite que o conteúdo semântico da imagem seja quantificado para análise posterior. O valor deste subsistema é que permite ao software compreender as imagens fornecidas pelo usuário em um nível granular, transformando os pixels brutos em dados estruturados. Os principais artefatos que implementam isso são a interface e a classe DataExtractionService, que lidam com a conversão de imagem em dados, e o modelo ExtractDataDto, que encapsula os dados extraídos. Isso difere do subsistema de aprendizado de máquina porque se concentra estritamente no processamento e quantificação de imagens, em vez de realizar análises preditivas.

##  Aprendizado de máquina
O subsistema Machine Learning fornece recursos para classificar imagens com base nas características visuais extraídas. Ele aplica modelos estatísticos aos dados numéricos do subsistema de processamento de imagens para prever qual caractere uma imagem provavelmente representa. Isso permite que o software identifique automaticamente o assunto da imagem carregada pelo usuário. O valor deste subsistema é que ele permite funcionalidade de classificação robusta sem exigir regras manuais ou lógica complexa dos desenvolvedores. A interface e a classe ImageClassifierService permitem isso abrigando modelos pré-treinados que podem ser aplicados a novos dados. Isso difere do subsistema de processamento de imagem porque se concentra na modelagem preditiva em vez da análise de imagem em nível de pixel.

## Interface web
O subsistema Web Interface permite a interação do usuário por meio de um frontend web. Ele fornece os controladores, modelos e ativos estáticos necessários para permitir uploads de imagens e exibir resultados no navegador. Isso oferece aos usuários uma maneira intuitiva de aproveitar os recursos do sistema. O valor é que ele abstrai os detalhes técnicos dos serviços de back-end, expondo apenas as principais interações necessárias por meio de interfaces web padrão. O HomeController lida com solicitações e respostas do usuário, suportadas por modelos HTML, JavaScript e CSS. Isso difere de outros subsistemas que se concentram no processamento backend em vez da apresentação ao usuário.

## Processamento de imagem
O subsistema de processamento de imagens fornece funcionalidade para extrair dados significativos de imagens enviadas pelo usuário. Ele converte os pixels brutos da imagem em representações numéricas que capturam características visuais como perfis de cores e formas de objetos. Isso permite que o conteúdo semântico da imagem seja quantificado para análise posterior. O valor deste subsistema é que permite ao software compreender as imagens fornecidas pelo usuário em um nível granular, transformando os pixels brutos em dados estruturados. Os principais artefatos que implementam isso são a interface e a classe DataExtractionService, que lidam com a conversão de imagem em dados, e o modelo ExtractDataDto, que encapsula os dados extraídos. Isso difere do subsistema de aprendizado de máquina porque se concentra estritamente no processamento e quantificação de imagens, em vez de realizar análises preditivas.

## Aprendizado de máquina
O subsistema Machine Learning fornece recursos para classificar imagens com base nas características visuais extraídas. Ele aplica modelos estatísticos aos dados numéricos do subsistema de processamento de imagens para prever qual caractere uma imagem provavelmente representa. Isso permite que o software identifique automaticamente o assunto da imagem carregada pelo usuário. O valor deste subsistema é que ele permite funcionalidade de classificação robusta sem exigir regras manuais ou lógica complexa dos desenvolvedores. A interface e a classe ImageClassifierService permitem isso abrigando modelos pré-treinados que podem ser aplicados a novos dados. Isso difere do subsistema de processamento de imagem porque se concentra na modelagem preditiva em vez da análise de imagem em nível de pixel.

## Interface web
O subsistema Web Interface permite a interação do usuário por meio de um frontend web. Ele fornece os controladores, modelos e ativos estáticos necessários para permitir uploads de imagens e exibir resultados no navegador. Isso oferece aos usuários uma maneira intuitiva de aproveitar os recursos do sistema. O valor é que ele abstrai os detalhes técnicos dos serviços de back-end, expondo apenas as principais interações necessárias por meio de interfaces web padrão. O HomeController lida com solicitações e respostas do usuário, suportadas por modelos HTML, JavaScript e CSS. Isso difere de outros subsistemas que se concentram no processamento backend em vez da apresentação ao usuário.

## Fluxo de dados
O sistema permite aos usuários classificar imagens de personagens dos Simpsons por meio de uma interface web intuitiva. Os usuários começam enviando um arquivo de imagem representando um personagem usando o formulário de upload de imagens. Esta imagem é passada para o serviço de extração de dados, que analisa o conteúdo do pixel para produzir uma série de características numéricas que representam características visuais como cores de roupas e atributos faciais.
A matriz de características numéricas é então alimentada no serviço de classificação de imagens, que utiliza um modelo de aprendizado de máquina pré-treinado para prever qual personagem dos Simpsons é mais provavelmente representado com base nos dados visuais. A classificação de caracteres prevista é retornada.
Por fim, as características numéricas extraídas e a classificação de caracteres prevista são exibidas ao usuário na interface web, fornecendo resultados informativos sobre a imagem que ele carregou. Esse fluxo contínuo desde o upload da imagem até a análise visual, classificação e exibição de resultados permite que os usuários identifiquem facilmente os personagens dos Simpsons por meio de um sistema automatizado de análise de imagens.

## Required jars:
* Weka
* OpenCV
