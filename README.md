# LabXpert - l'API REST via Spring Boot integer spring security avec Oauth 2.0 ( Part 4 )

(Lab Xpert part 4 Spring security avec OAuth 2.0)

## Configuration de la Sécurité (SecurityConfig.java)

## Description : 
 - Cette classe configure la sécurité de l'application en utilisant Spring Security. Elle définit les filtres pour l'authentification JWT et l'autorisation des requêtes HTTP.

# Méthodes principales :

## filterChain(HttpSecurity http) :
 - Configure les filtres de sécurité pour l'authentification et l'autorisation.

## authenticationManager(AuthenticationConfiguration authenticationConfiguration) : 
 - Renvoie le gestionnaire d'authentification pour l'application.

## passwordEncoder() : 
 -Renvoie l'encodeur de mot de passe à utiliser pour le hachage des mots de passe.

## Service de Détails de l'Utilisateur (UserDetailsServiceImpl.java):

## Description : 
 - Ce service charge les détails de l'utilisateur à partir de la base de données et les utilise pour créer un objet UserDetails utilisé par Spring Security pour l'authentification.

# Méthodes principales :

## loadUserByUsername(String email) : 
 - Charge les détails de l'utilisateur à partir de l'e-mail et les encapsule dans un objet UserDetails.
   
## Helper JWT (JWTHelper.java)

## Description : 
- Ce composant fournit des méthodes utilitaires pour générer, valider et extraire des JWT (JSON Web Tokens).

# Méthodes principales :
## generateAccessToken(String email, List<String> roles) : 
- Génère un token d'accès JWT avec le sujet et les rôles spécifiés.

## generateRefreshToken(String email) : 
- Génère un token de rafraîchissement JWT avec le sujet spécifié.

## extractTokenFromHeaderIfExists(String authorizationHeader) : 
- Extrait le token JWT d'un en-tête d'autorisation si présent.

## getTokensMap(String jwtAccessToken, String jwtRefreshToken) : 
- Retourne une carte contenant les tokens JWT d'accès et de rafraîchissement.

## Filtres JWT (JWTAuthenticationFilter.java, JWTAuthorizationFilter.java)
## Description : 
Ces filtres interagissent avec les requêtes HTTP pour gérer l'authentification JWT et l'autorisation des utilisateurs.

# Méthodes principales :
## attemptAuthentication(HttpServletRequest request, HttpServletResponse response) : 
- Tente d'authentifier l'utilisateur en utilisant les informations fournies dans la requête.

## successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) : 
- Gère la réponse après une authentification réussie en générant et renvoyant des tokens JWT.

## doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) :
- Extrait et valide le token JWT des requêtes entrantes, puis configure l'authentification en fonction des informations du token.

# Tous les Contrôleur:
## @PreAuthority:

## Description : 
Ces contrôleur gère les requêtes HTTP pour les fonctionnalités d’application, en appliquant des autorisations basées sur les rôles des utilisateurs(Admin, Technicien, Responsable).

**************************************************************************************************************************************************************************

Le laboratoire médical TechLab a besoin d'une application de gestion, LabXpert, pour optimiser ses opérations en améliorant l'efficacité et la précision dans le traitement des analyses médicales.

Ce référentiel contient des classes Java qui représentent les entités du système LabXpert, un laboratoire d'analyse médicale. Ci-dessous, vous trouverez une brève description de chaque classe fournie :

## Analyse
La classe Analyse représente une analyse médicale effectuée par le laboratoire. Elle contient des informations telles que le technicien responsable, l'échantillon associé, le statut du résultat, le type d'analyse, les dates de début et de fin, ainsi que des commentaires.

## Echontillon
La classe Echontillon représente un échantillon médical soumis au laboratoire pour analyse. Elle comprend des détails tels que le patient associé, la date de prélèvement, le statut de l'échantillon, et la liste des analyses effectuées.

## Fournisseur
La classe Fournisseur représente un fournisseur de réactifs médicaux. Elle contient des informations telles que le nom complet du fournisseur, le nom de la société, et la liste des réactifs fournis.

## Patient
La classe Patient hérite de la classe abstraite Person et représente un patient du laboratoire. Elle inclut des détails spécifiques au patient tels que l'âge et la liste des échantillons associés.

## Person
La classe abstraite Person représente une entité générique avec des informations personnelles de base, telles que le nom, le prénom, l'adresse, le numéro de téléphone, la ville, le sexe et la date de naissance.

## Planification
La classe Planification représente la planification d'une analyse. Elle contient des détails tels que l'analyse associée, le technicien en charge, ainsi que les dates de début et de fin de la planification.

## RapportStatistique
La classe RapportStatistique représente un rapport statistique généré par le laboratoire. Elle inclut des informations telles que le type de rapport, la période statistique, les données statistiques et un graphique associé.

## Reactif
La classe Reactif représente un réactif médical utilisé dans les analyses. Elle comprend des informations telles que le nom, la description, la quantité en stock, la date d'expiration, et le fournisseur associé.

## Result
La classe Result représente le résultat d'une sous-analyse. Elle inclut la valeur du résultat, l'unité de mesure, et la sous-analyse associée.

## SousAnalyse
La classe SousAnalyse représente une sous-analyse effectuée dans le cadre d'une analyse principale. Elle contient des informations telles que le titre, les valeurs normales, l'analyse associée, le réactif utilisé, et le statut du résultat.

## User
La classe User représente un utilisateur du système LabXpert. Elle hérite de la classe Person et inclut des détails spécifiques à l'utilisateur tels que l'e-mail, le mot de passe, le rôle, ainsi que les listes d'analyses et de planifications associées.

Ces classes fournissent une structure de base pour modéliser les entités du laboratoire d'analyse médicale dans le système LabXpert.

# Digramme classes

![ConceptionDigrammeClassLabXpert](https://github.com/Mouslih0/lab-xpert-spring-boot/assets/106397107/301080c9-e24c-4a74-9e5a-e7ed6dd01438)

# Digramme Cas Utilisation:

![DiagrammeCasUtilisationLabXpert](https://github.com/Mouslih0/lab-xpert-spring-boot/assets/106397107/cb87d764-a498-4071-8b3b-ce3c77e7552c)


