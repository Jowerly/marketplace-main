// Move Labels
document.querySelectorAll('.input-box input').forEach(input => {
  function checkContent() {
    const label = input.nextElementSibling;
    if (input.value.trim() !== '') {
      input.classList.add('has-content');
    } else {
      input.classList.remove('has-content');
    }
  }
  input.addEventListener('input', checkContent);
  checkContent();
});