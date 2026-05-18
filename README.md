Created this springboot project for the to-do application backend.
For ease of use, currently using the embedded h2 database which saves the data in file.

The app also has MCP endpoints and hence can be used by AI agents such as codex.

# Commands:
All the commands needs to be run from the root directory

### To build the project:
`mvnw.cmd compile`

### To clean the project:
`mvnw.cmd clean`

### To run the app:
`mvnw.cmd spring-boot:run`

### To create the jar file:
`mvnw.cmd package`

### To install the app (places the jar into .m2/repository so that other projects can access it):
`mvnw.cmd install`


> **Note** : Recommendation is to first clean the project before compiling(building)/packaging/installing the project.

## Adding the mcp server of the app to codex:
In the `config.toml` file of your codex, paste the following:
```toml
[mcp_servers.todo-helper]
url="http://<server-host-name>:<port>/mcp"
enabled = true 
```
You can also add it directly by the Codex extension in VS code. Just Navigate to Codex settings -> MCP Servers -> Add. In this give the name as "todo-helper" and select the Streamable HTTP and paste the url and save.