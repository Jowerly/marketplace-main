(function() {
  function App() {}
  window.onload = function(event) {
    var app = new App();
    window.app = app;
  }
  
  App.prototype.processingButton = function(event) {
    const btn = event.currentTarget;
    const carruselList = btn.parentNode;
    const track = carruselList.querySelector('#track');
    const slickItems = track.querySelectorAll('.slick');
    const slickWidth = slickItems[0].offsetWidth; // Ancho de un elemento
    const listWidth = carruselList.offsetWidth; // Ancho del contenedor
    const trackWidth = track.scrollWidth; // Ancho total del track
    
    let leftPosition = parseFloat(track.style.left || '0'); // Posición actual del track
    const isPrev = btn.dataset.button === "button-prev";
    
    if (isPrev) {
      // Acción para el botón "prev"
      if (leftPosition < 0) {
        track.style.left = `${Math.min(leftPosition + slickWidth, 0)}px`;
      }
    } else {
      // Acción para el botón "next"
      if (Math.abs(leftPosition) + listWidth < trackWidth) {
        track.style.left = `${Math.max(leftPosition - slickWidth, -(trackWidth - listWidth))}px`;
      }
    }
  }

  const buttonPrev = document.getElementById('button-prev');
  const buttonNext = document.getElementById('button-next');

  buttonPrev.onclick = () => window.app.processingButton({currentTarget: buttonPrev});
  buttonNext.onclick = () => window.app.processingButton({currentTarget: buttonNext});
})();
function redirectToCart() {
  const form = event.target;
  fetch(form.action, {
      method: 'POST',
      body: new FormData(form)
  }).then(response => {
      if (response.ok) {
          // Redirigir a la página del carrito
          window.location.href = '/shop/cart';
      } else {
          // Manejar errores si es necesario
          console.error('Error al agregar el producto al carrito');
      }
      return false; // Evita el comportamiento predeterminado del formulario
  });
  return false; // Evita el comportamiento predeterminado del formulario
}