
<h1 align="center" style="font-weight: bold;"> Unifood - Backend 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Iniciando</a> • 
 <a href="#routes">Prerequisitos</a> •
</p>

<p align="center">
    Desenvolvida com base nos requisitos de avaliação.
</p>

<h2 id="technologies">💻 Tecnologias </h2>

<p align="center">
 
- ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
- ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
- ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
- ![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
</p>

<h2 id="started">🚀 Iniciando</h2>

## Rodando o projeto localmente:

<h3>Prerequisitos</h3>

- [Intellij](https://www.jetbrains.com/pt-br/idea/download/?section=windows)
- [Docker desktop instalado no seu sistema!](https://docs.docker.com/get-started/get-docker/).
- [Git instalado.](https://git-scm.com/downloads)
- [JDK Versão 17 ou maior!](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Virtualização permitida na BIOS. Procure pela configuração de CPU, e ative a virtualização de hardware.


:construction: :construction: :construction: :construction:
<h3>Requisitos opcionais</h3>
Caso queira poder visualizar com acesso direto ao pqsl...

- [Postgres](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

Talvez este comando faça issoooooo 
(a senha padrão é 'postgres')
```bash
docker run -it --rm postgres:latest psql -h host.docker.internal -U postgres -d postgres
```
:construction: :construction: :construction: :construction:

<h3> Clonando a aplicação <h3>

### Na sua maquina, acesse o DOS (Disk Operating System) e digite os seguintes comandos:

Navegue até o Desktop
```bash
cd Desktop
```
Crie o diretório
```bash
mkdir <NOME_DO_DIRETÓRIO>
```
Navegue até o diretório
```bash
cd <NOME_DO_EXATO_DIRETÓRIO>
```
Clone o projeto!
```bash
git clone https://github.com/DantonFSS/Backend-Unifood.git
```


## Verifique os Recursos do WSL
Certifique-se de que os seguintes recursos estão habilitados no Windows:
- **Subsistema do Windows para Linux**
- **Plataforma de Máquina Virtual**

## Passos:
1. Pressione `Win + R`, digite `optionalfeatures` e pressione Enter.
2. Na janela "Recursos do Windows", ative as seguintes opções:
   - **Subsistema do Windows para Linux**
   - **Plataforma de Máquina Virtual**
3. Clique em **OK** e reinicie o computador se solicitado.

---

### Verifique se a Virtualização está Habilitada
Certifique-se de que a virtualização está habilitada na BIOS/UEFI.

## Passos:
1. Reinicie o computador e acesse a BIOS/UEFI: (algumas máquinas Samsung já vêm com a virtualização habilitada de fábrica)
   - Pressione `Del`, `F2`, ou `Esc` durante a inicialização (varia de acordo com o fabricante).
2. Procure por uma configuração chamada:
   - **Intel VT-x**
   - **AMD-V**
   - Ou **Virtualização** (pode variar de acordo com o fabricante).
3. Certifique-se de que a opção está **Habilitada**.
4. Salve as alterações e reinicie o computador.


<h3>Instalando o Docker engine</h3>

Siga o processo normal do instalador...

## Lembre-se de deixar a opção "Use wsl2 instead of hyper-v (recommended)" selecionada.

Para testar o funcionamento:
```bash
sudo docker ps
```
Algo como 
CONTAINER ID   IMAGE      COMMAND                  CREATED      STATUS       PORTS                                       NAMES
deve aparacer...

## PODE SER PRECISO REINICIAR O COMPUTADOR

<h3>Criando e configurando .env variables</h2>

No diretório principal '.../Backend-Unifood/', siga:
![image](https://github.com/user-attachments/assets/c03659a3-d3ac-4e1b-9644-76de7370076b)

Clicando com o botão direito -> Novo arquivo (New file)
![image](https://github.com/user-attachments/assets/31e55bae-c5f1-4d8d-ad79-7f5b5a84e6c1)

Nomeie-o '.env'
![image](https://github.com/user-attachments/assets/3acd02c4-b030-4bf8-8e38-04e02342c8cd)

Agora insira as credenciais do banco no seu `.env`.
```yaml
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=develop
DATABASE_PORT=5432
```

<h3>Rodando a aplicação</h3>
Rodando o container do banco.

Sobe o container do banco.
```bash
sudo docker compose up -d
```

<h3>Acessando à documentação </h3>
Após rodar a aplicação, acesse:

```bash
http://localhost:8080/swagger-ui/index.html#/
```
