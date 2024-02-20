import './App.css'
import BMI from './components/BMI/BMI'
import Card from './components/Card/Card'
import Classes from './components/Classes/Classes'
import Contact from './components/Contact/Contact'
import Footer from './components/Footer/Footer'
import Header from './components/Header/Header'
import Navbar from "./components/Navbar/Navbar"
import Purchase from './components/Purchase/Purchase'
import Review from './components/Review/Review'
import Trainers from './components/Trainers/Trainers'

function App() {

  return (
    <>
      <Navbar />
      <Header />
      <Card />
      <Classes />
      <BMI />
      <Trainers />
      <Purchase />
      <Review />
      <Contact />
      <Footer />
    </>
  )
}

export default App
