# MultiChiefConstruction
<p><b>MultiChief</b> is an experimental microservice-based ERP system for construction industry (on-line and off-line interaction between departments and employees). <p/>
<p><b>MultiChiefConstruction</b> is a microservice that is responsible for preparing data (DTO) for orchestrators (modules of <a href="https://github.com/LevGoryachev/MultiChiefMain">MultiChiefMain</a>).</p> 
<p><b>Summary: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate)</b></p>
<p><b>Database: PostgreSQL</b></p>
<p><b>API:</b> deploy and follow /swagger-ui/</b>)</p>

<h3>Architecture</h3>
<p>Customized microservice-based domain-driven architecture.<p/>
<p><b>MultiChiefConstruction</b> is responsible for a certain functions of domain Construction (CRUD operations of subdomains, preparing special DTOs)
and does not interact with both other microservices and business-consumer-services.</p>

![MultiChiefConstructionDiagram](https://user-images.githubusercontent.com/61917893/141861431-e1d1fb6d-7faf-43f8-a2af-7330a5f44364.jpg)

<p><b>MultiChiefConstruction</b> has subdomains:
<ul>
<li>construction - object of building construction</li>
<li>bim - building information model table presents construction projects</li>
<li>eir - employer's information requirements</li>
<li>site - specific construction site which has certain location</li>
<li>estimate - estimate of certain construction site</li>
</ul>

<h3>Database scheme</h3>

![MultiChiefConstruction_DB_v1_1](https://user-images.githubusercontent.com/61917893/140859479-03c265b4-f5d5-4c4c-a9f7-70e94df6a579.jpg)

<p>Descriptions:</p>

<ul>
<li>bim - building information model table presents construction projects</li>
<li>eir - employer's information requirements</li>
<li>site - specific construction site which has certain location</li>
<li>lod - level of development (1-500) Russia: SP-333 1325800.2020</li>
</ul>

<p>MultiChief (ERP). License: GNU GPL v3. Copyright (C) 2021 Lev Goryachev.</p>
