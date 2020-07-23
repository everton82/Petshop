#language: pt
#encoding: utf-8

  Funcionalidade: Cadastro de usuário

    Esquema do Cenario: Cadastro de Usuario

    Dado a requisicao contem <id> <username> <firtname> <lastname> <email> <password> <phone> <userStatus>
      Quando conecto com a uri da Petshop
      Entao Valido <code> <type> <message>

    Exemplos:
    |id           | username         | firtname   | lastname    | email               | password    | phone          | userStatus  | code  | type      | message  |
    | "11820523"  | "AnaClaraER"     | "Ana"      | "Clara"     | "anaclar@test.com"  | "123456"    | "11999999999"  | 1           | 200   | "unknown" | 11820523 |
    | "21820523"  | "NoeCarlo"       | "Noe"      | "Carlo"     | "noecarl@test.com"  | "654321"    | "19999999999"  | 1           | 200   | "unknown" | 11820523 |