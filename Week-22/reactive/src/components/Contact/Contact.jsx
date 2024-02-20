import React from 'react'
import "./Contact.css"

function Contact() {
  return (
    <section id="contact">
      <div className="contact-container">
        <h2 className="titles">CONTACT US</h2>
        <div className="line-item"></div>
        <p className="desc-p">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Numquam,
          labore?
        </p>
        <div className="contact-content">
          <div className="contact-info">
            <div className="contact-types">
              <div className="mobile-number">
                <h4>Mobile Number</h4>
                <p>+135 773 321 44 42</p>
              </div>
              <div className="email-address">
                <h4>Email Adress</h4>
                <p>demo@demo.com</p>
              </div>
            </div>
            <h3>Make An Appointment</h3>
            <input type="text" id="name" placeholder="Your Name" />
            <input type="text" id="email" placeholder="Your Email" />
            <textarea
              name="message"
              id="message"
              placeholder="Your Message"
            ></textarea>
          </div>
          <div className="contact-map">
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d385399.3519826978!2d28.682534897266322!3d41.00485195720003!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14caa7040068086b%3A0xe1ccfe98bc01b0d0!2zxLBzdGFuYnVs!5e0!3m2!1sen!2str!4v1706817875990!5m2!1sen!2str"
              style={{border: 0}}
              loading="lazy"
              referrerPolicy="no-referrer-when-downgrade"
              className="map"
            ></iframe>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Contact