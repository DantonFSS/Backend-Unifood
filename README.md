
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

- Docker
- Java - Framework SpringBoot
- PostgresSQL
- Git

<h2 id="started">🚀 Iniciando</h2>

## Rodando o projeto localmente:

<h3>Prerequisites</h3>

- [Ide Intellij IDEA](https://www.jetbrains.com/pt-br/idea/download/?section=windows)![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
- ![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
- [Docker desktop instalado no seu sistema!](https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?utm_source=docker&utm_medium=webreferral&utm_campaign=docs-driven-download-win-amd64).
- Virtualização permitida na BIOS. Procure pela configuração de CPU, e ative a virtualização de hardware.
- [Git instalado.](https://git-scm.com/downloads)

<h3> Clonando a aplicação <h3>
No github, na pagina da aplicação, clique em:

[<> Code] e copie a chave HTTPS para clonar o repositório...

Na sua maquina, acesse o DOS (Disk Operating System) e digite os seguintes comandos:

Navega até o Desktop
```bash
cd Desktop
```

Cria diretório
```bash
mkdir <NOME_DO_DIRETÓRIO>
```

```bash
cd <NOME_DO_EXATO_DIRETÓRIO>
```

```bash
git clone <link_do_repositório>
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

Siga o processo normal do installer...

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

No diretório principal '.../growup_mb/', siga:
![image](https://github.com/user-attachments/assets/f38dea79-3fa6-45ed-8afa-e71bbdbe1759)

Clicando com o botão direito -> Novo arquivo
![image](https://github.com/user-attachments/assets/e982a533-0451-4bfe-93e6-a560a8a73537)

Nomeie-o '.env'
![image](https://github.com/user-attachments/assets/540c450f-bce9-45ea-a16e-f9bb956edddd)

<h3>Intalando os requirements</h3>

## Agora no terminal do proprio VS_Code, ele ja deve reconhecer com o terminal do Ubuntu...

algo como:
seu_usuario@DESKTOP-AUCS77G:~/mosca/growup_mb$ 

digite: 

```bash
sudo nano /etc/resolv.conf
```
## adicione as seguintes linhas:

```bash
nameserver 8.8.8.8
nameserver 8.8.4.4
```

Então pressione:
`CTRL + X` -> `y` -> `Enter`

```bash
sudo systemctl restart networking
```

Reinicie o Ubuntu.

Copie e cole os seguintes comandos:
Atualiza.
```bash
sudo apt-get update
```
```bash
sudo apt-get upgrade
```

Instala a engine python necessaria para o venv (v)irtual(env)ironment
```bash
sudo apt install python3.12-venv
```
Cria o venv
```bash
python3 -m venv venv
```

Instala dependências necessarias para o funcionamento
```bash
pip install -r requirements.txt
```
```bash
pip install numpy
```

Por fim, ativa o venv.
```bash
source venv/bin/activate
```

Agora insira as credenciais do banco no seu `.env`.
```yaml
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=dev
POSTGRES_HOST=localhost
POSTGRES_PORT=5432
```

<h3>Rodando a aplicação</h3>
Rodando o container do banco.

Sobe o container do banco.
```bash
sudo docker compose up -d
```
Instala o pacote para instalação do cliente postgres.
```bash
sudo apt install postgresql-client-common
```
Instala o cliente do postgres.
```bash
sudo apt-get install postgresql-client
```
Acessa o cliente disponivel no container rodando.
```bash
psql -h localhost -U postgres -d postgres
```
(a senha padrão é 'postgres')

<h3>Populando nossa base de dados</h3>

Primeiro, criaremos o esquema com o qual iremos trabalhar:
```bash
CREATE SCHEMA dev;
```

Comando para utilizar o schema criado.
```bash
\c dev
```

```bash
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
```

A partir daqui, utilize-se dos scripts sql no arquivo script.txt para criar as tabelas e relacionamento...
É necessario que crie na ordem (de cima a baixo) estabelecida no arquivo...
