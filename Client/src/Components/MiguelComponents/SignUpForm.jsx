import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Miguelstyles.css";
import { useUser } from "../../context/UserContext";

const SignUpForm = () => {
  const navigate = useNavigate();
  const { setUser } = useUser();
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(""); // Estado para mensagens de erro

  const handleSignUp = (e) => {
    e.preventDefault();

    // Verificar se todos os campos estão preenchidos
    if (!name || !email || !password) {
      setError("Todos os campos são obrigatórios.");
      return;
    }

    const users = JSON.parse(localStorage.getItem("users")) || [];

    // Verificar se o usuário já existe
    const userExists = users.some((user) => user.email === email);
    if (userExists) {
      setError("Usuário já cadastrado.");
      return;
    }

    // Criar e salvar o novo usuário
    const user = { name, email, password };
    users.push(user);
    localStorage.setItem("users", JSON.stringify(users));

    // Limpar o estado do erro e navegar para outra página
    setError("");
    setUser(user);
    navigate("/Donations");
  };

  return (
    <div className="form-container sign-up-container">
      <form className="form-miguel" action="#">
        <h1 className="h1-miguel">Crie sua Conta!</h1>
        {/* Exibir mensagem de erro */}
        {error && <p className="error-message">{error}</p>}
        <input
          className="input-miguel"
          type="text"
          placeholder="Nome"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <input
          className="input-miguel"
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          className="input-miguel"
          type="password"
          placeholder="Senha"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <div className="btn-grad" id="signup" onClick={handleSignUp}>
          Sign Up
        </div>
      </form>
    </div>
  );
};

export default SignUpForm;
